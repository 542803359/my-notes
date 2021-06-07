package com.xiaowenxing.demobuilder.employ;

import com.xiaowenxing.demobuilder.domin.Item;
import com.xiaowenxing.demobuilder.service.ItemBuild;

/**
 * 指挥者
 *
 * @author XWX
 * @date 2021/5/21 15:45
 * @since 3.2
 **/
public class Director {

    public Item createItem(ItemBuild itemBuild) {
        itemBuild.name();
        itemBuild.packing();
        itemBuild.price();
        Item item = itemBuild.getItem();
        return item;
    }
}
