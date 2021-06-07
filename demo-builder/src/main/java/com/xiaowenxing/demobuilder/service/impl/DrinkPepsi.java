package com.xiaowenxing.demobuilder.service.impl;

import com.xiaowenxing.demobuilder.domin.Item;
import com.xiaowenxing.demobuilder.service.Drink;

/**
 * 百事可乐
 *
 * @author XWX
 * @date 2021/5/21 15:37
 * @since 3.2
 **/
public class DrinkPepsi extends Drink {

    private Item item;

    public DrinkPepsi() {
        item = new Item();
    }


    @Override
    public void name() {
        item.setName("百事可乐");
    }

    @Override
    public void price() {
        item.setPrice(3.5);
    }

    @Override
    public Item getItem() {
        item.setPacking(super.packing().pack());
        return item;
    }
}
