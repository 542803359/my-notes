package com.xiaowenxing.demobuilder.service.impl;

import com.xiaowenxing.demobuilder.service.Packing;

/**
 * 用杯子打包
 *
 * @author XWX
 * @date 2021/5/21 15:21
 * @since 3.2
 **/
public class PackingGlass implements Packing {
    @Override
    public String pack() {
        return "do glass";
    }
}
