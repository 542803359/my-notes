package com.xiaowenxing.demofactory.absFactory.factory;

import com.xiaowenxing.demofactory.absFactory.service.AbsDrinkProduction;
import com.xiaowenxing.demofactory.factoryMethod.factory.DrinkEnum;
import com.xiaowenxing.demofactory.factoryMethod.service.DrinkProduction;

public interface Factory {

    AbsDrinkProduction createDrink(DrinkEnum drinkEnum);
}
