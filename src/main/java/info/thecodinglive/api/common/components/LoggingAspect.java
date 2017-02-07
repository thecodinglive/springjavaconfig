package info.thecodinglive.api.common.components;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by yun_dev1 on 2017-02-07.
 */
@Component
@Aspect
@Order(Ordered.LOWEST_PRECEDENCE)
public class LoggingAspect {
    private final Logger log = getLogger(LoggingAspect.class);

    @Before("execution(* com.ttp.dcms.api.winvention.service.*.*(..))")
    public void serviceMethodLogging(JoinPoint joinPoint){

    }


    @PostConstruct
    private void onCreatedLoggingAspect(){
        log.info("created Logging Aspect");
    }
}
