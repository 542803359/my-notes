package com.xiaowenxing.demoproxy.proxy.test;

import com.xiaowenxing.demoproxy.proxy.ProxyFactory;
import com.xiaowenxing.demoproxy.proxy.service.Work;
import com.xiaowenxing.demoproxy.proxy.service.impl.WorkImpl;

/**
 * @author XWX
 * @date 2021/6/4 18:26
 * @since 3.6
 **/
public class Demo {


    public static void main(String[] args) {


        WorkImpl work = new WorkImpl();

        ProxyFactory proxyFactory = new ProxyFactory(work);

        Work handler = (Work) proxyFactory.handler();

        handler.doWork();


    }
}
