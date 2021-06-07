package com.xiaowenxing.demodecorate.service.decorate;

import com.xiaowenxing.demodecorate.service.coffee.Coffee;

/**
 * 调料-摩卡
 *
 * @author XWX
 * @date 2021/5/25 17:36
 * @since 3.2
 **/
public class Mocha extends CondimentDecorator {

    /**
     * 用一个实例变量记录饮料，也就是被装饰者
     */
    public Coffee coffee;

    /**
     * 构造器初始化饮料变量
     *
     * @param coffee
     */
    public Mocha(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + "  Mocha";
    }

    @Override
    public String type() {
        return coffee.type()+"mocha";
    }

    @Override
    public Double cost() {
        return coffee.cost() + 3.5;
    }
}
