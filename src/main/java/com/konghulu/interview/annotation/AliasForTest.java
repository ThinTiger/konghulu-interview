package com.konghulu.interview.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * https://www.jianshu.com/p/869ed7037833
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AliasForTest {

    @AliasFor("alias")
    String value() default "";

    @AliasFor("value")
    String alias() default "";
}
