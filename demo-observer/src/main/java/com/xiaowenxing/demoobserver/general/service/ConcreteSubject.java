package com.xiaowenxing.demoobserver.general.service;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体主题
 *
 * @author XWX
 * @date 2021/6/7 15:33
 * @since 3.6
 **/
@Data
public class ConcreteSubject implements Subject {

    /**
     * 将有关状态存入具体观察者对象，在具体主题内部状态改变时，给所有登记过的观察者发出通知
     */

    private String name;

    private Integer age;

    //观察者集合
    private List<Observer> observerList = new ArrayList<>();


    public ConcreteSubject(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void add(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        if (observerList.contains(observer)) {
            observerList.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observerList) {
            observer.update(name, age);
        }
    }

}
