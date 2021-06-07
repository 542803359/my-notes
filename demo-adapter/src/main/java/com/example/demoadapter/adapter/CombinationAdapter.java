package com.example.demoadapter.adapter;

import com.example.demoadapter.service.CableOne;
import org.springframework.stereotype.Service;

/**
 * 组合适配器
 *
 * @author XWX
 * @date 2021/5/14 18:41
 * @since 3.2
 **/
@Service
public class CombinationAdapter implements UsbAdapter {

    private CableOne cableOne;



    public CombinationAdapter(CableOne cableOne) {
        this.cableOne = cableOne;
    }


    @Override
    public void handleSurfInternet() {
        cableOne.surfTheInternet();
    }
}
