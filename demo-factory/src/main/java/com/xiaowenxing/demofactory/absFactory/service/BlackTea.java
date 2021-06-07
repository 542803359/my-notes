package com.xiaowenxing.demofactory.absFactory.service;

/**
 * 生产红茶
 *
 * @author XWX
 * @date 2021/5/20 15:03
 * @since 3.2
 **/
public class BlackTea extends DrinkProduction {

    @Override
    public void createDrink() {

        System.out.println("生产红茶");
        super.name = "红茶";
        super.pickingDrink();
        super.bakeDrink();

    }

}
