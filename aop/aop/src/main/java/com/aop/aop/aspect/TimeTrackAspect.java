package com.aop.aop.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
public class TimeTrackAspect {
  @Around("@annotation(com.aop.aop.annotation.TimeTrack)")
  public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
    long start = System.currentTimeMillis();
    Object proceed = joinPoint.proceed();  // Proceed with the method execution
    long executionTime = System.currentTimeMillis() - start;
    log.info("{} executed in {}ms", joinPoint.getSignature().getName(), executionTime);
    return proceed;
  }
}
