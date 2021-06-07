package com.xiaowenxing.demofactory.factoryMethod;

import com.xiaowenxing.demofactory.factoryMethod.factory.CoffeeFactory;
import com.xiaowenxing.demofactory.factoryMethod.factory.DrinkEnum;
import com.xiaowenxing.demofactory.factoryMethod.factory.TeaFactory;
import com.xiaowenxing.demofactory.factoryMethod.service.DrinkProduction;

/**
 * @author XWX
 * @date 2021/5/20 16:52
 * @since 3.2
 **/
public class Consumer {

    public static void main(String[] args) {
        coffee();
        tea();
    }

    private static void coffee() {
        CoffeeFactory coffeeFactory = new CoffeeFactory();
        DrinkProduction usaCoffee = coffeeFactory.createDrink(DrinkEnum.USACOFFEE);
        usaCoffee.createDrink();
        System.out.println("====================");
        DrinkProduction capuccilo = coffeeFactory.createDrink(DrinkEnum.CAPUCCILO);
        capuccilo.createDrink();
    }

    private static void tea() {
        TeaFactory teaFactory = new TeaFactory();
        DrinkProduction greenTea = teaFactory.createDrink(DrinkEnum.GREEN);
        greenTea.createDrink();
        System.out.println("====================");
        DrinkProduction blackTea = teaFactory.createDrink(DrinkEnum.BLACK);
        blackTea.createDrink();
    }
}
