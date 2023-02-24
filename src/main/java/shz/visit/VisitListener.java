package shz.visit;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;
import shz.core.time.TimeHelp;
import shz.orm.OrmService;
import shz.spring.ServletHelp;
import shz.visit.entity.SysVisit;
import shz.visit.recorder.VisitRecorder;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

public class VisitListener implements ServletRequestListener {
    final String appName;
    final VisitRecorder recorder;

    protected VisitListener(String appName, VisitRecorder recorder) {
        this.appName = appName;
        this.recorder = recorder;
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ServletRequest servletRequest = sre.getServletRequest();
        if (servletRequest == null) return;

        SysVisit visit = new SysVisit();
        servletRequest.setAttribute(VisitHelp.VISIT, visit);
        visit.setId(OrmService.get().nonNullClassInfo(SysVisit.class).idProducer.next());
        visit.setCreateTime(LocalDateTime.now());
        visit.setAppName(appName);
        visit.setLogin(Boolean.FALSE);
        visit.setException(Boolean.FALSE);
        visit.setRecord(Boolean.TRUE);

        if (servletRequest instanceof HttpServletRequest) {
            HttpServletRequest request = (HttpServletRequest) servletRequest;

            visit.setIp(ServletHelp.getIp(request));
            visit.setPort(request.getRemotePort());
            visit.setMac(request.getHeader("Mac"));

            visit.setPath(request.getServletPath());
            visit.setMethod(request.getMethod());
            visit.setReferer(request.getHeader("Referer"));

            UserAgent userAgent = ServletHelp.getUserAgent(request);
            visit.setBrowser(Optional.ofNullable(userAgent.getBrowser()).map(Browser::getName).orElse(null));
            visit.setBrowserVersion(Optional.ofNullable(userAgent.getBrowserVersion()).map(Version::getVersion).orElse(null));
            visit.setOs(Optional.ofNullable(userAgent.getOperatingSystem()).map(OperatingSystem::getName).orElse(null));

            visit.setAjax(ServletHelp.isAjax(request));
        }
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        SysVisit visit = VisitHelp.get(sre.getServletRequest());
        if (visit == null || !visit.isRecord()) return;
        visit.setDestroyedTime(LocalDateTime.now());
        visit.setElapsedTime(TimeHelp.between(ChronoUnit.MILLIS, visit.getCreateTime(), visit.getDestroyedTime()));
        recorder.accept(visit);
    }
}
