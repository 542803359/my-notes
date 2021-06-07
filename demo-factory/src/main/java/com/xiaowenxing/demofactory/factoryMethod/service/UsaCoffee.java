package com.xiaowenxing.demofactory.factoryMethod.service;

import com.xiaowenxing.demofactory.simple.service.TeaProduction;

/**
 * 生产红茶
 *
 * @author XWX
 * @date 2021/5/20 15:03
 * @since 3.2
 **/
public class UsaCoffee extends DrinkProduction {

    @Override
    public void createDrink() {

        System.out.println("生产美式咖啡");
        super.name = "美式咖啡";
        super.pickingDrink();
        super.bakeDrink();

    }

}
