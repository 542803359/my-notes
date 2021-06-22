package com.xiaowenxing.demotemplate.service.impl;

import com.xiaowenxing.demotemplate.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户业务实现类
 *
 * @author XWX
 * @date 2021/6/21 10:39
 * @since 3.6
 **/
@Service
public class UserServiceImpl implements UserService {


    @Override
    public void getUserInfo() {
        System.out.println("执行具体业务");
    }
}
