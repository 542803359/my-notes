package com.xiaowenxing.demodecorate.service.coffee;

/**
 * 拿铁咖啡
 *
 * @author XWX
 * @date 2021/5/25 17:25
 * @since 3.2
 **/
public class LatteCoffee extends Coffee {

    public LatteCoffee() {
        description = "拿铁";
    }

    @Override
    public String type() {
        return "b";
    }

    @Override
    public Double cost() {
        return 13.5;
    }
}
