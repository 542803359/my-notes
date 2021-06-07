package com.xiaowenxing.demobuilder.employ;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.xiaowenxing.demobuilder.domin.Item;
import com.xiaowenxing.demobuilder.service.Burger;
import com.xiaowenxing.demobuilder.service.impl.BurgerVeg;
import com.xiaowenxing.demobuilder.service.impl.DrinkPepsi;
import com.xiaowenxing.demobuilder.service.impl.FrenchFries;

/**
 * 消费者
 *
 * @author XWX
 * @date 2021/5/21 15:54
 * @since 3.2
 **/
public class Consumer {

    public static void main(String[] args) {
        Director director = new Director();

        Item item = director.createItem(new BurgerVeg());
        System.out.println(item);

        Item item1 = director.createItem(new DrinkPepsi());
        System.out.println(item1);

        Item item2 = director.createItem(new FrenchFries());
        System.out.println(item2);
    }
}
