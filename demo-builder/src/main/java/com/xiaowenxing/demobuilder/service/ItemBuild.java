package com.xiaowenxing.demobuilder.service;

import com.xiaowenxing.demobuilder.domin.Item;

/**
 * 菜单建造者
 *
 * @author XWX
 * @date 2021/5/21 15:28
 * @since 3.2
 **/
public interface ItemBuild {

    public void name();

    public Packing packing();

    public void price();

    public Item getItem();


}
