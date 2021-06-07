package com.xiaowenxing.demoobserver.general.service;

/**
 * 抽象的主题
 *
 * @author XWX
 * @date 2021/6/7 15:28
 * @since 3.6
 **/
public interface Subject {

    public void add(Observer observer);

    public void remove(Observer observer);

    public void notifyObserver();
}
