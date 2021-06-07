package com.xiaowenxing.demodecorate.service.coffee;

/**
 * 美式咖啡
 *
 * @author XWX
 * @date 2021/5/25 17:25
 * @since 3.2
 **/
public class AmericanCoffee extends Coffee {

    public AmericanCoffee() {
        description = "美式咖啡";
    }


    @Override
    public String type() {
        return "a";
    }

    @Override
    public Double cost() {
        return 12.0;
    }
}
