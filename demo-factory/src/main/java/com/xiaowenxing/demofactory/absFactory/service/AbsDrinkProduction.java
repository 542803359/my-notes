package com.xiaowenxing.demofactory.absFactory.service;

/**
 * 生产茶叶抽象类 抽象公共的方法
 *
 * @author XWX
 * @date 2021/5/20 14:55
 * @since 3.2
 **/
public abstract class AbsDrinkProduction {

    public String name;

    /**
     * 生产饮料
     */
    public abstract void createDrink();

    public void pickingDrink() {
        System.out.println("采集原材料 "+name);
    }

    public void bakeDrink() {
        System.out.println(name + "  开始加工");
    }
}
