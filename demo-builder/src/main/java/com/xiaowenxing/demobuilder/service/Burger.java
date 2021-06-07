package com.xiaowenxing.demobuilder.service;

import com.xiaowenxing.demobuilder.domin.Item;
import com.xiaowenxing.demobuilder.service.impl.PackingPaper;

/**
 * 汉堡抽象类
 *
 * @author XWX
 * @date 2021/5/21 15:16
 * @since 3.2
 **/
public abstract class Burger implements ItemBuild{


    /**
     * 用纸打包
     * @return
     */
    @Override
    public Packing packing() {
        return new PackingPaper();
    }

}
