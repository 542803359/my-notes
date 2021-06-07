package com.xiaowenxing.demodecorate.service.coffee;

/**
 * 咖啡饮品抽象类
 *
 * @author XWX
 * @date 2021/5/25 17:04
 * @since 3.2
 **/
public abstract class Coffee {

    /**
     * 商品描述
     */
    String description = "";

    public String getDescription() {
        return description;
    }

    public abstract String type();

    /**
     * cost方法是用来返回饮料的价钱（需在具体类中自己实现）
     *
     * @return
     */
    public abstract Double cost();
}
