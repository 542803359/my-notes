package com.xiaowenxing.liteflow.controller;

import com.xiaowenxing.liteflow.vo.ShoppingVO;
import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 工作台模式 控制器
 *
 * @author xiaowx
 * @date 2022/07/05 10:40:55
 */
@RestController
public class LiteFlowController {

    @Resource
    private FlowExecutor flowExecutor;


    @RequestMapping(value = "/shopTest", method = RequestMethod.POST)
    @ResponseBody
    public String shopTest(@Nullable @RequestBody String reqData) {
        try {
            LiteflowResponse shoppingChain = flowExecutor.execute2Resp("shoppingChain", reqData, ShoppingVO.class);
            return shoppingChain.getContextBean(ShoppingVO.class).getName();
        } catch (Throwable t) {
            t.printStackTrace();
            return "error";
        }
    }

}
