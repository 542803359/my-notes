package com.xiaowenxing.demofactory.simple.service;

import com.xiaowenxing.demofactory.simple.service.TeaProduction;

/**
 * 生产红茶
 *
 * @author XWX
 * @date 2021/5/20 15:03
 * @since 3.2
 **/
public class BlackTea extends TeaProduction {

    @Override
    public void createTea() {

        System.out.println("生产红茶");
        super.teaName = "红茶";
        super.pickingTea();
        super.bakeTea();

    }

}
