package com.xiaowenxing.liteflow.shopping;

import com.xiaowenxing.liteflow.vo.ShoppingVO;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 结束购物
 *
 * @author xiaowx
 * @date 2022/07/05 17:22:51
 */
@Slf4j
@Component("endShopping")
public class EndShopping extends NodeComponent {

    @Override
    public void process() throws Exception {
        //获取用户
        String name = this.getSlot().getRequestData();
        //获取上下文
        ShoppingVO contextBean = this.getContextBean(ShoppingVO.class);
        //处理逻辑
        BigDecimal priceTotal = contextBean.getDiscountPriceTotal();
        log.info("⑩->用户结束购物:{} 付款金额:{}", name, priceTotal.toPlainString());
    }
}
