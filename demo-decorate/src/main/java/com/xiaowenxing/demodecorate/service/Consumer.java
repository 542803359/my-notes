package com.xiaowenxing.demodecorate.service;

import com.xiaowenxing.demodecorate.service.coffee.AmericanCoffee;
import com.xiaowenxing.demodecorate.service.coffee.Coffee;
import com.xiaowenxing.demodecorate.service.decorate.Milk;
import com.xiaowenxing.demodecorate.service.decorate.Mocha;

/**
 * 调用者
 *
 * @author XWX
 * @date 2021/5/25 17:40
 * @since 3.2
 **/
public class Consumer {

    public static void main(String[] args) {

        Coffee americanCoffee = new AmericanCoffee();

        System.out.println(americanCoffee.getDescription());
        System.out.println(americanCoffee.cost());
        System.out.println(americanCoffee.type());
        System.out.println("====================");

        americanCoffee = new Mocha(americanCoffee);

        System.out.println(americanCoffee.getDescription());
        System.out.println(americanCoffee.cost());
        System.out.println(americanCoffee.type());
        System.out.println("====================");

        americanCoffee = new Milk(americanCoffee);

        System.out.println(americanCoffee.getDescription());
        System.out.println(americanCoffee.cost());
        System.out.println(americanCoffee.type());


    }
}
