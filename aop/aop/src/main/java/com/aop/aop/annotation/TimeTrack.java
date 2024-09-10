package com.aop.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)  // Annotation can only be applied to methods
@Retention(RetentionPolicy.RUNTIME)  // Annotation will be available at runtime
public @interface TimeTrack {
}
