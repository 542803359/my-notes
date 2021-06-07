package com.xiaowenxing.demofactory.factoryMethod.factory;

import com.xiaowenxing.demofactory.factoryMethod.service.DrinkProduction;

/**
 * 饮料抽象工厂
 *
 * @author XWX
 * @date 2021/5/20 16:19
 * @since 3.2
 **/
public abstract class DrinkFactory {

    public abstract DrinkProduction createDrink(DrinkEnum drinkEnum);
}
