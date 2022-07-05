package com.xiaowenxing.liteflow.shopping.goods;

import cn.hutool.core.util.RandomUtil;
import com.xiaowenxing.liteflow.vo.ShoppingVO;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component("beef")
@Slf4j
public class Beef extends NodeComponent {
    @Override
    public void process() throws Exception {
        //获取上下文,逻辑处理
        ShoppingVO context = this.getContextBean(ShoppingVO.class);
        List<ShoppingVO.BuyList> shopSome = context.getBuyLists();
        ShoppingVO.BuyList buyList = new ShoppingVO.BuyList();
        buyList.setGoodsName("牛肉");
        buyList.setGoodsNum(RandomUtil.randomInt(1, 3));
        buyList.setPrice(BigDecimal.valueOf(30));
        shopSome.add(buyList);
        log.info("②->选购 {} ,单价:{},数量:{}", buyList.getGoodsName(), buyList.getPrice(), buyList.getGoodsNum());
    }

    @Override
    public boolean isAccess() {
        return super.isAccess();
    }
}
