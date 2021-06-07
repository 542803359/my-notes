package com.xiaowenxing.demofactory.simple.factory;

import com.xiaowenxing.demofactory.simple.service.BlackTea;
import com.xiaowenxing.demofactory.simple.service.GreenTea;
import com.xiaowenxing.demofactory.simple.service.TeaProduction;

/**
 * 简单工厂
 * 制作茶的工厂
 *
 * @author XWX
 * @date 2021/5/20 15:10
 * @since 3.2
 **/
public class TeaSimpleFactory {


    /*
     * 缺点:扩展性差（我想增加一种茶，除了新增一个茶产品类，还需要修改工厂类方法）
     *     而且如果使用时传递的type、Class出错，将不能得到正确的对象，容错率不高
     */

    public TeaProduction createTeaForFactory(TeaEnum teaEnum) {

        TeaProduction tea = null;

        if (teaEnum.equals(TeaEnum.BLACK)) {
            tea = new BlackTea();
        } else if (teaEnum.equals(TeaEnum.GREEN)) {
            tea = new GreenTea();
        }
        return tea;
    }

}
