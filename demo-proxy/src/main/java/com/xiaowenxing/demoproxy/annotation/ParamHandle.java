package com.xiaowenxing.demoproxy.annotation;

import java.lang.annotation.*;

/**
 * 参数处理注解
 *
 * @author XWX
 * @date 2021/6/9 17:18
 * @since 3.6
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ParamHandle {

}
