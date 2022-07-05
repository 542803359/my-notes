package com.xiaowenxing.liteflow.shopping;

import com.xiaowenxing.liteflow.vo.ShoppingVO;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Slf4j
@Component("supermarket")
public class Supermarket extends NodeComponent {

    @Override
    public void process() throws Exception {
        //获取用户
        String name = this.getSlot().getRequestData();
        log.info("①->用户:{} 进入超市选购", name);
        //将用户信息放入上下文
        ShoppingVO contextBean = this.getContextBean(ShoppingVO.class);
        contextBean.setName(name);
        //初始化一个购物清单
        contextBean.setBuyLists(new ArrayList<>());
    }

    @Override
    public boolean isAccess() {
        //此处可进行过滤是否进入该流程
        String name = this.getSlot().getRequestData();
        if (StringUtils.isNotEmpty(name)) {
            return true;
        } else {
            return false;
        }
    }

}
