package com.xiaowenxing.demofactory.absFactory.service;

/**
 * 生产绿茶
 *
 * @author XWX
 * @date 2021/5/20 15:03
 * @since 3.2
 **/
public class AbsCapucciloCoffee extends AbsDrinkProduction {

    @Override
    public void createDrink() {

        System.out.println("生产卡布奇洛");
        super.name = "卡布奇洛";
        super.pickingDrink();
        super.bakeDrink();

    }

}
