package com.xiaowenxing.demobuilder.domin;

import lombok.Data;

/**
 * 菜单
 *
 * @author XWX
 * @date 2021/5/21 15:09
 * @since 3.2
 **/
@Data
public class Item {

    private String name;

    /**
     * 打包方式
     */
    private String packing;

    private Double price;
}
