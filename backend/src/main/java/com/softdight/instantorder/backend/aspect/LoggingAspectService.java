package com.softdight.instantorder.backend.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;


@Aspect
@Service
public class LoggingAspectService {

    private static final Logger LOGGER = LogManager.getLogger(LoggingAspectService.class);

    @Pointcut("@annotation(com.softdight.instantorder.backend.aspect.annotation.Log)")
    public void log() {
    }

    @Before("log()")
    public void before(final JoinPoint joinPoint) {
        final String method = joinPoint.getSignature().toShortString();
        LOGGER.info("---> in @Before: calling method: " + method);

        final Object[] args = joinPoint.getArgs();

        for (final Object tempArg : args) {
            LOGGER.info("---> argument: " + tempArg);
        }
    }

    @AfterReturning(value = "log()", returning = "result")
    public void afterReturning(final JoinPoint joinPoint, final Object result) {
        final String method = joinPoint.getSignature().toShortString();

        LOGGER.info("===>> in @AfterReturning: from method: " + method);

        LOGGER.info("===>> result: " + result);
    }

}
