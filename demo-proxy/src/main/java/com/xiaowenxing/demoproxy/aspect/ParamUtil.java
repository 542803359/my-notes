package com.xiaowenxing.demoproxy.aspect;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author XWX
 * @date 2021/6/9 17:39
 * @since 3.6
 **/
@Component
public class ParamUtil {

    public String getParam() {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String mobile = request.getParameter("mobile");
        return mobile;
    }


}
