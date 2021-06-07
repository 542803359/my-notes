package com.xiaowenxing.demodecorate.service.decorate;

import com.xiaowenxing.demodecorate.service.coffee.Coffee;

/**
 * 调料-牛奶
 *
 * @author XWX
 * @date 2021/5/25 17:36
 * @since 3.2
 **/
public class Milk extends CondimentDecorator {

    /**
     * 用一个实例变量记录饮料，也就是被装饰者
     */
    public Coffee coffee;

    /**
     * 构造器初始化饮料变量
     *
     * @param coffee
     */
    public Milk(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + "  Milk";
    }

    @Override
    public String type() {
        return coffee.type() + "milk";
    }

    @Override
    public Double cost() {
        return coffee.cost() + 2;
    }
}
