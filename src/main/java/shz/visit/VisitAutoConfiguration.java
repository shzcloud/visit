package shz.visit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import shz.spring.filter.FilterHelp;
import shz.visit.hash.VisitConsistentHash;
import shz.visit.hash.VisitDataConsistentHash;
import shz.visit.recorder.VisitDataRecorder;
import shz.visit.recorder.VisitRecorder;
import shz.visit.service.VisitDataService;
import shz.visit.service.VisitService;

@Configuration(proxyBeanMethods = false)
class VisitAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean(VisitService.class)
    VisitService visitService() {
        return new VisitService();
    }

    @Bean
    @ConditionalOnMissingBean(VisitRecorder.class)
    VisitRecorder visitRecorder(VisitService service) {
        return service::insert;
    }

    @Bean
    @ConditionalOnMissingBean(VisitConsistentHash.class)
    VisitConsistentHash visitConsistentHash() {
        return new VisitConsistentHash();
    }

    @Bean
    @ConditionalOnMissingBean(VisitListener.class)
    VisitListener visitListener(@Value("${spring.application.name:DEFAULT}") String appName, VisitRecorder recorder) {
        return new VisitListener(appName, recorder);
    }

    @Bean
    ServletListenerRegistrationBean<VisitListener> visitListenerRegistrationBean(VisitListener listener) {
        ServletListenerRegistrationBean<VisitListener> slrb = new ServletListenerRegistrationBean<>();
        slrb.setOrder(Ordered.HIGHEST_PRECEDENCE);
        slrb.setListener(listener);
        return slrb;
    }

    @Bean
    @ConditionalOnMissingBean(VisitFilter.class)
    VisitFilter visitFilter() {
        return new VisitFilter();
    }

    @Bean
    FilterRegistrationBean<VisitFilter> visitFilterRegistrationBean(VisitFilter filter) {
        return FilterHelp.registrationBean(filter);
    }

    @Bean
    @ConditionalOnProperty(name = "visit.data.enabled", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean(VisitDataService.class)
    VisitDataService visitDataService() {
        return new VisitDataService();
    }

    @Bean
    @ConditionalOnBean(VisitDataService.class)
    @ConditionalOnMissingBean(VisitDataRecorder.class)
    VisitDataRecorder visitDataRecorder(VisitDataService service) {
        return service::insert;
    }

    @Bean
    @ConditionalOnBean(VisitDataRecorder.class)
    @ConditionalOnMissingBean(VisitDataConsistentHash.class)
    VisitDataConsistentHash visitDataConsistentHash() {
        return new VisitDataConsistentHash();
    }

    @Bean
    @ConditionalOnBean(VisitDataRecorder.class)
    @ConditionalOnMissingBean(VisitDataAdvisor.class)
    VisitDataAdvisor visitDataAdvisor(VisitDataRecorder recorder) {
        return new VisitDataAdvisor(recorder);
    }
}
