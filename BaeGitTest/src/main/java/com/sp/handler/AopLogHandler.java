package com.sp.handler;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
public class AopLogHandler {

    @Around("within(com.sp.contorller.*)")
    public Object logBefore(ProceedingJoinPoint point) throws Throwable {

        long start = System.currentTimeMillis();
        Object resultVal = point.proceed();
        long processTime = System.currentTimeMillis() - start;

        StringBuffer sb = new StringBuffer();
        Object[] params = point.getArgs();

        int i = 0;
        for (Object param : params) {
            if (param != null) {
                if (i > 0) sb.append(", ");
                sb.append(param.toString());
                i++;
            }
        }

        log.info("---------------------------------------------------------------------------------------------------------------------------");
        log.info("Processing Time({}) : {} ms", point.getSignature().toShortString(), processTime);
        log.info("Param : {}", sb.toString());
        log.info("Result : {}", resultVal.toString());
        log.info("---------------------------------------------------------------------------------------------------------------------------");

        return resultVal;
    }

}
