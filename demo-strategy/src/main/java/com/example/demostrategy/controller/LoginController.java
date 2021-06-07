package com.example.demostrategy.controller;

import com.example.demostrategy.strategy.LoginForWx;
import com.example.demostrategy.strategy.LoginStrategy;
import com.example.demostrategy.strategy.context.LoginEnum;
import com.example.demostrategy.strategy.context.StrategyContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XWX
 * @date 2021/5/13 19:04
 * @since 3.2
 **/
@RestController
@RequestMapping("/test")
public class LoginController {

    @Autowired
    private StrategyContext strategyContext;

    @GetMapping("/login")
    public void login() {
        LoginStrategy loginStrategy = new LoginStrategy(new LoginForWx());

        loginStrategy.login();
    }


    @GetMapping("/loginForContext")
    public void loginForContext() {
        strategyContext.login("loginForWx");

    }

    @GetMapping("/loginForContextEnum")
    public void loginForContextEnum() {
        strategyContext.login(LoginEnum.VCODE.getLoginName());

    }
}
