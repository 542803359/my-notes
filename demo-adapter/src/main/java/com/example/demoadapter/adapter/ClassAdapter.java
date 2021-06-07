package com.example.demoadapter.adapter;

import com.example.demoadapter.service.CableOne;
import org.springframework.stereotype.Service;

/**
 * usb 类适配器,使用继承
 *
 * @author XWX
 * @date 2021/5/14 18:18
 * @since 3.2
 **/
@Service
public class ClassAdapter extends CableOne implements UsbAdapter {

    @Override
    public void handleSurfInternet() {
        super.surfTheInternet();
    }
}
