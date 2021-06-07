package com.example.demostrategy.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author XWX
 * @date 2021/5/13 18:57
 * @since 3.2
 **/
@Service
@Slf4j
public class LoginForVcode implements UserLogin {

    @Override
    public void login() {
        System.out.println("验证码登录");
    }

}
