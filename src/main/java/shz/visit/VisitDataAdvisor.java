package shz.visit;

import org.springframework.aop.support.DefaultPointcutAdvisor;
import shz.visit.recorder.VisitDataRecorder;

public class VisitDataAdvisor extends DefaultPointcutAdvisor {
    private static final long serialVersionUID = -9133135079288442L;

    public VisitDataAdvisor(VisitDataRecorder recorder) {
        super(recorder.pointcut(), recorder.interceptor());
    }
}
