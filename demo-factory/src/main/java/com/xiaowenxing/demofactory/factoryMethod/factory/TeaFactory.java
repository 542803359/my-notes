package com.xiaowenxing.demofactory.factoryMethod.factory;

import com.xiaowenxing.demofactory.factoryMethod.service.*;

/**
 * 咖啡工厂
 *
 * @author XWX
 * @date 2021/5/20 16:20
 * @since 3.2
 **/
public class TeaFactory extends DrinkFactory {


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
