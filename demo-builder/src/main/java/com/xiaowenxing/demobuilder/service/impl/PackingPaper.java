package com.xiaowenxing.demobuilder.service.impl;

import com.xiaowenxing.demobuilder.service.Packing;

/**
 * 用纸打包
 *
 * @author XWX
 * @date 2021/5/21 15:20
 * @since 3.2
 **/
public class PackingPaper implements Packing {
    @Override
    public String pack() {
        return "do paper";
    }
}
