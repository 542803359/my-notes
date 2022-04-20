package com.xiaowenxing.demofactory.absFactory.factory;

import com.xiaowenxing.demofactory.absFactory.service.AbsCapucciloCoffee;
import com.xiaowenxing.demofactory.absFactory.service.AbsDrinkProduction;
import com.xiaowenxing.demofactory.absFactory.service.AbsUsaCoffee;
import com.xiaowenxing.demofactory.factoryMethod.factory.DrinkEnum;
import com.xiaowenxing.demofactory.factoryMethod.factory.DrinkFactory;
import com.xiaowenxing.demofactory.factoryMethod.service.CapucciloCoffee;
import com.xiaowenxing.demofactory.factoryMethod.service.DrinkProduction;
import com.xiaowenxing.demofactory.factoryMethod.service.UsaCoffee;

/**
 * 咖啡工厂
 *
 * @author XWX
 * @date 2021/5/20 16:20
 * @since 3.2
 **/
public class CoffeeFactory implements Factory {


    @Override
    public AbsDrinkProduction createDrink(DrinkEnum drinkEnum) {
        if (drinkEnum.equals(DrinkEnum.USACOFFEE)) {
            return new AbsUsaCoffee();
        } else if (drinkEnum.equals(DrinkEnum.CAPUCCILO)) {
            return new AbsCapucciloCoffee();
        }
        return null;
    }
}
