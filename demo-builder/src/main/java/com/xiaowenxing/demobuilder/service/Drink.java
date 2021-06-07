package com.xiaowenxing.demobuilder.service;

import com.xiaowenxing.demobuilder.service.impl.PackingGlass;

/**
 * 饮料抽象类
 *
 * @author XWX
 * @date 2021/5/21 15:37
 * @since 3.2
 **/
public abstract class Drink implements ItemBuild {

    /**
     * 用杯子打包
     * @return
     */
    @Override
    public Packing packing() {
        return new PackingGlass();
    }
}
