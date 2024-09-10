package com.aop.aop.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
public class LoggingAspect {

  // Before advice
  @Before("execution(* com.aop.aop.service.MyService.*(..))")
  public void logBefore() {
    log.info("Method is about to be executed.");
  }

  // After returning advice
  @AfterReturning(pointcut = "execution(* com.aop.aop.service.MyService.*(..))", returning = "result")
  public void logAfterReturning(Object result) {
    log.info("Method executed successfully, result: {}", result);
  }

  // After throwing advice
  @AfterThrowing(pointcut = "execution(* com.aop.aop.service.MyService.*(..))", throwing = "exception")
  public void logAfterThrowing(Exception exception) {
    log.error("Method threw an exception: {}", exception.getMessage());
  }

  // Around advice
  @Around("execution(* com.aop.aop.service.MyService.*(..))")
  public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
    log.info("Method execution starts: {}", joinPoint.getSignature().getName());
    Object result = joinPoint.proceed();  // Proceed with method execution
    log.info("Method execution ends: {}", joinPoint.getSignature().getName());
    return result;
  }
}