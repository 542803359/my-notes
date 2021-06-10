package com.xiaowenxing.demoproxy.proxy.service.impl;

import com.xiaowenxing.demoproxy.proxy.service.Work;
import org.springframework.stereotype.Service;

/**
 * @author XWX
 * @date 2021/6/4 18:16
 * @since 3.6
 **/
@Service
public class WorkImpl implements Work {
    @Override
    public void doWork() {
        System.out.println("do something");
    }
}
