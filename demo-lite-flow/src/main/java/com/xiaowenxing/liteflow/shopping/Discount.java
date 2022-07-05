package com.xiaowenxing.liteflow.shopping;


import com.xiaowenxing.liteflow.vo.ShoppingVO;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 折扣
 *
 * @author xiaowx
 * @date 2022/07/05 17:12:37
 */
@Slf4j
@Component("discount")
public class Discount extends NodeComponent {


    @Override
    public void process() throws Exception {
        //获取用户
        String name = this.getSlot().getRequestData();
        //获取上下文
        ShoppingVO contextBean = this.getContextBean(ShoppingVO.class);
        //处理逻辑
        BigDecimal priceTotal = contextBean.getPriceTotal();
        BigDecimal discountPrice = priceTotal.multiply(new BigDecimal("0.8")).setScale(2,BigDecimal.ROUND_DOWN);
        contextBean.setDiscountPriceTotal(discountPrice);
        log.info("⑧->用户进入优惠通道:{} 商品价格:{},优惠后价格:{}", name, priceTotal.toPlainString(), discountPrice.toPlainString());
    }
}
