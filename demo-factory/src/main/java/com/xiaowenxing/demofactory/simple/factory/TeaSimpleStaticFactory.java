package com.xiaowenxing.demofactory.simple.factory;

import com.xiaowenxing.demofactory.simple.service.BlackTea;
import com.xiaowenxing.demofactory.simple.service.GreenTea;
import com.xiaowenxing.demofactory.simple.service.TeaProduction;

/**
 * 多方法静态工厂（常用）
 * 制作茶的工厂
 *
 * @author XWX
 * @date 2021/5/20 15:10
 * @since 3.2
 **/
public class TeaSimpleStaticFactory {

    /*
     * 多方法的工厂模式为不同产品，提供不同的生产方法，使用时 需要哪种产品就调用该种产品的方法，使用方便、容错率高
     */

    public static TeaProduction createGreenTea() {

        return new GreenTea();
    }


    public static TeaProduction createBlackTea() {

        return new BlackTea();
    }

}
