package com.xiaowenxing.demobuilder.service.impl;

import com.xiaowenxing.demobuilder.domin.Item;
import com.xiaowenxing.demobuilder.service.ItemBuild;
import com.xiaowenxing.demobuilder.service.Packing;

/**
 * 薯条(单独的类)
 *
 * @author XWX
 * @date 2021/5/21 15:41
 * @since 3.2
 **/
public class FrenchFries implements ItemBuild {

    private Item item;

    public FrenchFries() {
        item = new Item();
    }

    @Override
    public void name() {
        item.setName("薯条");
    }

    @Override
    public Packing packing() {
       return new PackingPaper();
    }

    @Override
    public void price() {
        item.setPrice(6.5);
    }

    @Override
    public Item getItem() {
        item.setPacking(packing().pack());
        return item;
    }
}
