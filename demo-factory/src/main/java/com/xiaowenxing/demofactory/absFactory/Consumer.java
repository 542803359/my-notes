package com.xiaowenxing.demofactory.absFactory;

import com.xiaowenxing.demofactory.absFactory.factory.CoffeeFactory;
import com.xiaowenxing.demofactory.absFactory.factory.Factory;
import com.xiaowenxing.demofactory.absFactory.factory.FactoryProducer;
import com.xiaowenxing.demofactory.absFactory.factory.TeaFactory;
import com.xiaowenxing.demofactory.absFactory.service.AbsDrinkProduction;
import com.xiaowenxing.demofactory.factoryMethod.factory.DrinkEnum;
import com.xiaowenxing.demofactory.factoryMethod.service.DrinkProduction;

/**
 * @author XWX
 * @date 2021/5/20 17:56
 * @since 3.2
 **/
public class Consumer {


    public static void main(String[] args) {
      /*  coffee(new CoffeeFactory());

        tea(new TeaFactory());*/

        absTea();
    }


    private static void coffee(Factory factory) {
        factory.createDrink(DrinkEnum.USACOFFEE).createDrink();
    }

    private static void tea(Factory factory) {
        factory.createDrink(DrinkEnum.BLACK).createDrink();
    }

    private static void absTea() {
        FactoryProducer factoryProducer = new FactoryProducer(new TeaFactory());
        AbsDrinkProduction blackTea = factoryProducer.getFactory(DrinkEnum.BLACK);
        blackTea.createDrink();
    }


}
