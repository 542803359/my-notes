package com.xiaowenxing.demoproxy.aspect;

import java.lang.annotation.*;

/**
 * 访问限制注解
 *
 * @author XWX
 * @date 2021/6/9 17:18
 * @since 3.6
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AccessLimit {

    String className() default "";

    String methodName() default "";


}
