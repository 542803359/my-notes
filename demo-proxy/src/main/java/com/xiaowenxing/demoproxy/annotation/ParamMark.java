package com.xiaowenxing.demoproxy.annotation;

import java.lang.annotation.*;

/**
 * 参数标记注解
 *
 * @author XWX
 * @date 2021/6/9 17:18
 * @since 3.6
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ParamMark {

}
