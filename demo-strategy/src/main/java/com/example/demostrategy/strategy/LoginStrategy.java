package com.example.demostrategy.strategy;

import org.springframework.stereotype.Component;

/**
 * 第一种实现:常规通过多态,controller去new类,传入对应的UserLogin实现类去调用不同的实现类方法
 *
 * @author XWX
 * @date 2021/5/13 19:00
 * @since 3.2
 **/
public class LoginStrategy {


    private UserLogin userLogin;

    public LoginStrategy(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    public void login() {
        userLogin.login();
    }
}
