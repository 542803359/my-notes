package com.xiaowenxing.demofactory.absFactory.factory;

import com.xiaowenxing.demofactory.factoryMethod.factory.DrinkEnum;
import com.xiaowenxing.demofactory.factoryMethod.service.DrinkProduction;

/**
 * @author XWX
 * @date 2021/5/20 18:10
 * @since 3.2
 **/
public class FactoryProducer {

    private Factory factory;

    public FactoryProducer(Factory factory) {
        this.factory = factory;
    }

    public DrinkProduction getFactory(DrinkEnum drinkEnum){
        return factory.createDrink(drinkEnum);
    }
}
