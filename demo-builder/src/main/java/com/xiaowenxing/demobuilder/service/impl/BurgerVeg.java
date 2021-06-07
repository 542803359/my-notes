package com.xiaowenxing.demobuilder.service.impl;

import com.xiaowenxing.demobuilder.domin.Item;
import com.xiaowenxing.demobuilder.service.Burger;

/**
 * 牛肉汉堡
 *
 * @author XWX
 * @date 2021/5/21 15:33
 * @since 3.2
 **/
public class BurgerVeg extends Burger {

    private Item item;

    public BurgerVeg() {
        item = new Item();
    }

    @Override
    public void name() {
        item.setName("牛肉汉堡");
    }

    @Override
    public void price() {
        item.setPrice(12.5);
    }

    @Override
    public Item getItem() {
        item.setPacking(super.packing().pack());
        return item;
    }
}
