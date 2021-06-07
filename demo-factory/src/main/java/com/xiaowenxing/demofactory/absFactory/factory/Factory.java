package com.xiaowenxing.demofactory.absFactory.factory;

import com.xiaowenxing.demofactory.factoryMethod.factory.DrinkEnum;
import com.xiaowenxing.demofactory.factoryMethod.service.DrinkProduction;

public interface Factory {

    DrinkProduction createDrink(DrinkEnum drinkEnum);
}
