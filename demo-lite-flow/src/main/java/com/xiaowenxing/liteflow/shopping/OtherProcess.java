package com.xiaowenxing.liteflow.shopping;

import com.xiaowenxing.liteflow.vo.ShoppingVO;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 其他流程
 *
 * @author xiaowx
 * @date 2022/07/05 17:12:18
 */
@Slf4j
@Component("otherProcess")
public class OtherProcess extends NodeComponent {

    @Override
    public void process() throws Exception {
        //获取用户
        String name = this.getSlot().getRequestData();
        //获取上下文
        ShoppingVO contextBean = this.getContextBean(ShoppingVO.class);
        //处理逻辑
        BigDecimal priceTotal = contextBean.getPriceTotal();
        contextBean.setDiscountPriceTotal(priceTotal);
        log.info("⑨->用户进入其他处理通道:{} 商品价格:{},处理后的价格:{}", name, priceTotal.toPlainString(), priceTotal.toPlainString());
    }
}
