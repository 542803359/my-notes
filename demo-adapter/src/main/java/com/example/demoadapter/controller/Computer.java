package com.example.demoadapter.controller;

import com.example.demoadapter.adapter.ClassAdapter;
import com.example.demoadapter.adapter.CombinationAdapter;
import com.example.demoadapter.adapter.UsbAdapter;
import com.example.demoadapter.service.CableOne;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XWX
 * @date 2021/5/14 18:04
 * @since 3.2
 **/
@RestController
@RequestMapping("/test")
public class Computer {

    /**
     * 这是一个电脑类,
     * 在service中用一个网线接口提供上网,
     * 假设该电脑的网线接口坏了,不能通过网线上网
     * 需要一个适配器,
     * 适配器一端连接电脑USB,一端连接网线
     */


    private void net(UsbAdapter usbAdapter){
        usbAdapter.handleSurfInternet();
    }


    /**
     * 电脑上网接口 类适配器
     */
    @GetMapping("/classAdapter")
    public void classAdapter() {

        net(new ClassAdapter());

    }

    /**
     * 电脑上网接口 组合适配器
     */
    @GetMapping("/combinationAdapter")
    public void combinationAdapter() {

        net(new CombinationAdapter(new CableOne()));

    }

}
