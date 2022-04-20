package com.xiaowenxing.demofactory.absFactory.service;

/**
 * 生产红茶
 *
 * @author XWX
 * @date 2021/5/20 15:03
 * @since 3.2
 **/
public class AbsUsaCoffee extends AbsDrinkProduction {

    @Override
    public void createDrink() {

        System.out.println("生产美式咖啡");
        super.name = "美式咖啡";
        super.pickingDrink();
        super.bakeDrink();

    }

}
