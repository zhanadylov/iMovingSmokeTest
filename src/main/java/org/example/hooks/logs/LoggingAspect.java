package org.example.hooks.logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);

    @Before("@annotation(Log)")
    public void logTestExecution(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Starting " + methodName + "...");
    }
}
