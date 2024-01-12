package org.example.hooks.logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);
//    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

//    @Before("@annotation(Log)")
//    public void logTestExecution(JoinPoint joinPoint) {
//        String methodName = joinPoint.getSignature().getName();
//        logger.info("Starting " + methodName + "...");
//    }

    @Before("execution(* src.main.java..*.*(..))")
    public void logMainExecution(JoinPoint joinPoint) {
        logExecution(joinPoint);
    }

    @Before("execution(* src.test.java.tests..*.*(..))")
    public void logTestExecution(JoinPoint joinPoint) {
        logExecution(joinPoint);
    }

    private void logExecution(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Starting " + methodName + "...");
    }

}
