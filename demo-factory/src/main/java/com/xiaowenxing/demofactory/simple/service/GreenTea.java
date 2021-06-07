package com.xiaowenxing.demofactory.simple.service;

/**
 * 生产绿茶
 *
 * @author XWX
 * @date 2021/5/20 15:03
 * @since 3.2
 **/
public class GreenTea extends TeaProduction {

    @Override
    public void createTea() {

        System.out.println("生产绿茶");
        super.teaName = "绿茶";
        super.pickingTea();
        super.bakeTea();

    }

}
