package com.xiaowenxing.demofactory.absFactory.factory;

import com.xiaowenxing.demofactory.factoryMethod.factory.DrinkEnum;
import com.xiaowenxing.demofactory.factoryMethod.factory.DrinkFactory;
import com.xiaowenxing.demofactory.factoryMethod.service.BlackTea;
import com.xiaowenxing.demofactory.factoryMethod.service.DrinkProduction;
import com.xiaowenxing.demofactory.factoryMethod.service.GreenTea;

/**
 * 咖啡工厂
 *
 * @author XWX
 * @date 2021/5/20 16:20
 * @since 3.2
 **/
public class TeaFactory implements Factory {


    @Override
    public DrinkProduction createDrink(DrinkEnum drinkEnum) {
        if (drinkEnum.equals(DrinkEnum.GREEN)) {
            return new GreenTea();
        } else if (drinkEnum.equals(DrinkEnum.BLACK)) {
            return new BlackTea();
        }
        return null;
    }
}
