package com.xiaowenxing.liteflow.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 购物返回类,测试使用
 *
 * @author xiaowx
 * @date 2022/07/05 10:41:45
 */
@Data
public class ShoppingVO {

    /**
     * 名字
     */
    private String name;

    /**
     * 购买列表
     */
    private List<BuyList> buyLists;

    /**
     * 商品总
     */
    private Integer goodsTotal;

    /**
     * 价格总
     */
    private BigDecimal priceTotal;

    /**
     * 优惠后价格总
     */
    private BigDecimal discountPriceTotal;

    /**
     * 购物清单
     */
    @Data
    public static class BuyList {

        /**
         * 商品名称
         */
        private String goodsName;

        /**
         * 价格
         */
        private BigDecimal price;

        /**
         * 货物num
         */
        private Integer goodsNum;
    }
}
