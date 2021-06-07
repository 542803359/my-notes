package com.xiaowenxing.demofactory.simple;

import com.xiaowenxing.demofactory.simple.factory.TeaEnum;
import com.xiaowenxing.demofactory.simple.factory.TeaSimpleFactory;
import com.xiaowenxing.demofactory.simple.factory.TeaSimpleStaticFactory;
import com.xiaowenxing.demofactory.simple.service.TeaProduction;

/**
 * 消费类
 *
 * @author XWX
 * @date 2021/5/20 15:21
 * @since 3.2
 **/
public class Consumer {

    /*
     *简单工厂模式缺点:
     *  工厂类集中了所有实例（产品）的创建逻辑，一旦这个工厂不能正常工作，整个系统都会受到影响；
     *  违背“开放 - 关闭原则”，一旦添加新产品就不得不修改工厂类的逻辑，这样就会造成工厂逻辑过于复杂。
     *  简单工厂模式由于使用了静态工厂方法，静态方法不能被继承和重写，会造成工厂角色无法形成基于继承的等级结构。
     */

    public static void main(String[] args) {
        // createBlackTea();

        createBlackTeaForStaticFactory();
    }

    private static void createBlackTea() {
        TeaSimpleFactory teaSimpleFactory = new TeaSimpleFactory();
        TeaProduction teaForFactory = teaSimpleFactory.createTeaForFactory(TeaEnum.BLACK);
        teaForFactory.createTea();
    }

    private static void createBlackTeaForStaticFactory() {
        TeaProduction blackTea = TeaSimpleStaticFactory.createBlackTea();
        blackTea.createTea();

        System.out.println("========================");

        TeaSimpleStaticFactory.createGreenTea().createTea();

    }


}
