package shz.visit;

import com.alibaba.fastjson2.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import shz.core.PRException;
import shz.core.model.Response;
import shz.core.msg.ClientFailureMsg;
import shz.core.msg.FailureMsg;
import shz.core.msg.ServerFailure;
import shz.core.msg.ServerFailureMsg;
import shz.spring.filter.DefaultFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class VisitFilter implements DefaultFilter {
    private static final Logger log = LoggerFactory.getLogger(VisitFilter.class);

    @Override
    public int order() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        FailureMsg msg = null;
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (PRException e) {
            msg = e.msg();
            VisitHelp.setException(servletRequest, msg.code(), msg.msg());
            if (!(msg instanceof ClientFailureMsg)) log.error(e.getMessage(), e);
        }

        if (servletResponse instanceof HttpServletResponse) {
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            int status = response.getStatus();
            if (status != HttpServletResponse.SC_OK) {
                if (msg != null) response.setStatus(HttpServletResponse.SC_OK);
                else VisitHelp.setException(servletRequest, status, null);
            }

            if (msg != null) {
                Response<?> fail;
                if (msg instanceof ServerFailureMsg && msg.code() == ServerFailure.INTERNAL_ERROR.code())
                    fail = Response.fail();
                else fail = Response.fail(msg);

                String contentType = response.getContentType();
                if (contentType == null) response.setHeader("Content-Type", "application/json; charset=utf-8");
                else if (!contentType.toLowerCase().contains("application/json"))
                    response.addHeader("Content-Type", "application/json");

                try (PrintWriter writer = response.getWriter()) {
                    writer.write(JSON.toJSONString(fail));
                    writer.flush();
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
    }
}
