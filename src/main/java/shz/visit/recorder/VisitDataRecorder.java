package shz.visit.recorder;

import com.alibaba.fastjson2.JSON;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.web.multipart.MultipartFile;
import shz.core.NullHelp;
import shz.core.ToMap;
import shz.core.model.PageInfo;
import shz.core.model.Response;
import shz.core.model.Result;
import shz.core.type.TypeHelp;
import shz.visit.VisitHelp;
import shz.visit.entity.SysVisit;
import shz.visit.entity.SysVisitData;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.function.Consumer;

@FunctionalInterface
public interface VisitDataRecorder extends Consumer<SysVisitData> {
    default Pointcut pointcut() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("@annotation(org.springframework.web.bind.annotation.RequestMapping) " +
                "|| @annotation(org.springframework.web.bind.annotation.GetMapping) " +
                "|| @annotation(org.springframework.web.bind.annotation.PostMapping) " +
                "|| @annotation(org.springframework.web.bind.annotation.PutMapping) " +
                "|| @annotation(org.springframework.web.bind.annotation.PatchMapping) " +
                "|| @annotation(org.springframework.web.bind.annotation.DeleteMapping)");
        return pointcut;
    }

    default MethodInterceptor interceptor() {
        return invocation -> {
            SysVisitData visitData = null;
            SysVisit visit = VisitHelp.get();
            if (visit != null && visit.isRecord() && visit.getId() != null) {
                visitData = new SysVisitData();
                visitData.setVisitId(visit.getId());
                visitData.setRequestData(getRequest(invocation.getArguments()));
            }

            Object proceed = invocation.proceed();

            if (visitData != null) {
                visitData.setResponseData(getResponse(proceed));
                accept(visitData);
            }

            return proceed;
        };
    }

    default String getRequest(Object[] args) {
        if (args.length == 0) return null;
        StringBuilder sb = new StringBuilder();
        for (Object arg : args) {
            if (NullHelp.isEmpty(arg) || arg instanceof ServletRequest || arg instanceof ServletResponse) continue;
            if (arg instanceof MultipartFile) {
                MultipartFile file = (MultipartFile) arg;
                sb.append(JSON.toJSONString(ToMap.get(4)
                        .put("name", file.getName())
                        .put("originalFilename", file.getOriginalFilename())
                        .put("contentType", file.getContentType())
                        .put("size", file.getSize())
                        .build()));
            } else if (TypeHelp.likeModel(arg.getClass())) sb.append(JSON.toJSONString(arg));
            else sb.append(arg);
        }
        return sb.toString();
    }

    default String getResponse(Object res) {
        Object data;
        if (res instanceof Response) data = ((Response<?>) res).getPayload();
        else if (res instanceof Result) data = ((Result<?>) res).getData();
        else if (res instanceof PageInfo) data = ((PageInfo<?>) res).getData();
        else data = res;
        if (NullHelp.isEmpty(data)) return null;
        if (TypeHelp.likeModel(data.getClass())) return JSON.toJSONString(data);
        return data.toString();
    }
}
