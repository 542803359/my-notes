package com.example.demostrategy.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author XWX
 * @date 2021/5/13 18:59
 * @since 3.2
 **/
@Service
@Slf4j
public class LoginForWx implements UserLogin {


    @Override
    public void login() {
        System.out.println("微信登录");
    }
}
