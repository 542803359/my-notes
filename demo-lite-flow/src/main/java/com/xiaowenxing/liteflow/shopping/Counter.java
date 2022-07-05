package com.xiaowenxing.liteflow.shopping;

import com.xiaowenxing.liteflow.vo.ShoppingVO;
import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.core.NodeSwitchComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@Slf4j
@Component("counter")
public class Counter extends NodeSwitchComponent {

    @Override
    public String processSwitch() throws Exception {
        //获取用户
        String name = this.getSlot().getRequestData();
        log.info("⑦->用户:{} 进入选完商品来到收银台", name);
        //获取上下文
        ShoppingVO contextBean = this.getContextBean(ShoppingVO.class);
        //计算金额
        List<ShoppingVO.BuyList> buyLists = contextBean.getBuyLists();
        //初始化数据
        AtomicInteger goodsTotal = new AtomicInteger();
        BigDecimal priceTotal = BigDecimal.ZERO;
        for (ShoppingVO.BuyList buyList : buyLists) {
            goodsTotal.addAndGet(buyList.getGoodsNum());
            priceTotal = priceTotal.add(buyList.getPrice().multiply(BigDecimal.valueOf(buyList.getGoodsNum())));
        }
        contextBean.setGoodsTotal(goodsTotal.get());
        contextBean.setPriceTotal(priceTotal);
        log.info("总商品数量:{},总金额:{}", goodsTotal.get(), priceTotal.toPlainString());

        //如果价格大于99,则走打折流程
        if (priceTotal.compareTo(new BigDecimal(99)) > 0) {
            return "discount";
        } else {
            return "otherProcess";
        }
    }
}
