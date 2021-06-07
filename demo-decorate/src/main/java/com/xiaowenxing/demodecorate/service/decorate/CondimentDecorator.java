package com.xiaowenxing.demodecorate.service.decorate;

import com.xiaowenxing.demodecorate.service.coffee.Coffee;

/**
 * 调料装饰者抽象类
 *
 * @author XWX
 * @date 2021/5/25 17:30
 * @since 3.2
 **/
public abstract class CondimentDecorator extends Coffee {

    /**
     * 所有的调料装饰者都必须重新实现getDescription()方法
     * 这样才能够用递归的方式来得到所选饮料的整体描述
     *
     * @return
     */
    @Override
    public abstract String getDescription();
}
