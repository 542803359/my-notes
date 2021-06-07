package com.xiaowenxing.demofactory.simple.service;

/**
 * 生产茶叶抽象类 抽象公共的方法
 *
 * @author XWX
 * @date 2021/5/20 14:55
 * @since 3.2
 **/
public abstract class TeaProduction {

    public String teaName;

    /**
     * 生产茶叶
     */
    public abstract void createTea();

    public void pickingTea() {
        System.out.println("采茶");
    }

    public void bakeTea() {
        System.out.println(teaName + "  开始烘干");
    }
}
