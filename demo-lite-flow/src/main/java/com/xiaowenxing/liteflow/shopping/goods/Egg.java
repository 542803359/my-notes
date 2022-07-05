package com.xiaowenxing.liteflow.shopping.goods;

import cn.hutool.core.util.RandomUtil;
import com.xiaowenxing.liteflow.vo.ShoppingVO;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Component("egg")
public class Egg extends NodeComponent {
    @Override
    public void process() throws Exception {
        //获取上下文,逻辑处理
        ShoppingVO context = this.getContextBean(ShoppingVO.class);
        List<ShoppingVO.BuyList> shopSome = context.getBuyLists();
        ShoppingVO.BuyList buyList = new ShoppingVO.BuyList();
        buyList.setGoodsName("鸡蛋");
        buyList.setGoodsNum(RandomUtil.randomInt(10, 15));
        buyList.setPrice(BigDecimal.valueOf(1.3));
        shopSome.add(buyList);
        log.info("⑥->选购 {} ,单价:{},数量:{}", buyList.getGoodsName(), buyList.getPrice(), buyList.getGoodsNum());
    }
}
