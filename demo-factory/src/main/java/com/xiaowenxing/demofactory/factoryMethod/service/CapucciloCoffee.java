package com.xiaowenxing.demofactory.factoryMethod.service;

import com.xiaowenxing.demofactory.simple.service.TeaProduction;

/**
 * 生产绿茶
 *
 * @author XWX
 * @date 2021/5/20 15:03
 * @since 3.2
 **/
public class CapucciloCoffee extends DrinkProduction {

    @Override
    public void createDrink() {

        System.out.println("生产卡布奇洛");
        super.name = "卡布奇洛";
        super.pickingDrink();
        super.bakeDrink();

    }

}
