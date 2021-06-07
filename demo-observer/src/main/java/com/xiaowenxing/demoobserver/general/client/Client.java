package com.xiaowenxing.demoobserver.general.client;

import com.xiaowenxing.demoobserver.general.service.ConcreteObserve;
import com.xiaowenxing.demoobserver.general.service.ConcreteSubject;

/**
 * @author XWX
 * @date 2021/6/7 15:42
 * @since 3.6
 **/
public class Client {

    public static void main(String[] args) {

        ConcreteSubject concreteSubject = new ConcreteSubject("张三",10);

        ConcreteObserve concreteObserve = new ConcreteObserve();

        concreteSubject.add(concreteObserve);

        concreteSubject.notifyObserver();





    }
}
