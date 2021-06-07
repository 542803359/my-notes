package com.xiaowenxing.demoobserver.general.service;

/**
 * 抽象观察者
 *
 * @author XWX
 * @date 2021/6/7 15:29
 * @since 3.6
 **/
public interface Observer {

    public void update(String name, Integer age);
}
