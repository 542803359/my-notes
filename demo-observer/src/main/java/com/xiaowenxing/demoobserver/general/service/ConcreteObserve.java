package com.xiaowenxing.demoobserver.general.service;

/**
 * 具体观察者
 *
 * @author XWX
 * @date 2021/6/7 15:40
 * @since 3.6
 **/
public class ConcreteObserve implements Observer {
    @Override
    public void update(String name, Integer age) {
        System.out.println(name + " " + age + " 报道");
    }
}
