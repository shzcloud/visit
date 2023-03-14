package shz.visit;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;
import shz.core.Coder;
import shz.core.hash.MdHash;
import shz.core.id.IdHelp;
import shz.spring.ServletHelp;
import shz.visit.entity.SysVisit;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.function.Consumer;

public final class VisitHelp {
    private VisitHelp() {
        throw new IllegalStateException();
    }

    static final String VISIT = Coder.hexEncode(MdHash.SHA256.hash(IdHelp.nanoId().getBytes()));

    public static SysVisit get(ServletRequest request) {
        return request == null ? null : (SysVisit) request.getAttribute(VISIT);
    }

    public static SysVisit get() {
        return get(ServletHelp.getRequest());
    }

    public static void set(ServletRequest request, Consumer<SysVisit> setter) {
        if (setter == null) return;
        SysVisit visit = get(request);
        if (visit != null) setter.accept(visit);
    }

    public static void set(Consumer<SysVisit> setter) {
        set(ServletHelp.getRequest(), setter);
    }

    public static void setException(ServletRequest request, int code, String msg) {
        set(request, visit -> {
            if (visit.getException() == Boolean.FALSE) {
                visit.setException(Boolean.TRUE);
                visit.setExceptionCode(code);
                visit.setExceptionMsg(msg);
            }
        });
    }

    public static void setException(int code, String msg) {
        setException(ServletHelp.getRequest(), code, msg);
    }

    public static Long getId(ServletRequest request) {
        SysVisit visit = get(request);
        return visit == null ? null : visit.getId();
    }

    public static Long getId() {
        return getId(ServletHelp.getRequest());
    }

    public static String getAppName(ServletRequest request) {
        SysVisit visit = get(request);
        return visit == null ? null : visit.getAppName();
    }

    public static String getAppName() {
        return getAppName(ServletHelp.getRequest());
    }

    public static Long getUserid(ServletRequest request) {
        SysVisit visit = get(request);
        return visit == null ? null : visit.getUserid();
    }

    public static Long getUserid() {
        return getUserid(ServletHelp.getRequest());
    }

    public static String getUsername(ServletRequest request) {
        SysVisit visit = get(request);
        return visit == null ? null : visit.getUsername();
    }

    public static String getUsername() {
        return getUsername(ServletHelp.getRequest());
    }

    public static boolean isDba() {
        SysVisit visit = get();
        return visit != null && visit.isDba();
    }

    public static String getIp(ServletRequest request) {
        SysVisit visit = get(request);
        return visit == null ? null : visit.getIp();
    }

    public static String getIp() {
        return getIp(ServletHelp.getRequest());
    }

    public static String signData(SysVisit visit) {
        return visit.getIp() + "-" + visit.getMac() + "-" + visit.getBrowser() + "-" + visit.getBrowserVersion() + "-" + visit.getOs();
    }

    public static String signData(HttpServletRequest request) {
        UserAgent userAgent = ServletHelp.getUserAgent(request);
        return ServletHelp.getIp(request) + "-" + request.getHeader("Mac") + "-" + Optional.ofNullable(userAgent.getBrowser()).map(Browser::getName).orElse(null) + "-" + Optional.ofNullable(userAgent.getBrowserVersion()).map(Version::getVersion).orElse(null) + "-" + Optional.ofNullable(userAgent.getOperatingSystem()).map(OperatingSystem::getName).orElse(null);
    }
}
