package com.xiaowenxing.demostate.statemachine;

import com.xiaowenxing.demostate.statemachine.domin.Order;
import com.xiaowenxing.demostate.statemachine.domin.R;
import com.xiaowenxing.demostate.statemachine.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 客户端类
 *
 * @author XWX
 * @date 2021/6/10 16:47
 * @since 3.6
 **/
@Slf4j
@RestController
@RequestMapping("/orderStatus")
public class Client {

    @Resource
    private OrderService orderService;

    @GetMapping("/createOrder")
    public R<Order> createOrder() {
        Order order = orderService.create();
        return R.ok(order);
    }

    @PostMapping("/pay")
    public R<Order> pay(@RequestParam(value = "orderId") Long orderId) {
        Order order = orderService.pay(orderId);
        return R.ok(order);
    }

    @PostMapping("/deliver")
    public R<Order> deliver(@RequestParam(value = "orderId") Long orderId) {
        Order order = orderService.deliver(orderId);
        return R.ok(order);
    }

    @PostMapping("/receive")
    public R<Order> receive(@RequestParam(value = "orderId") Long orderId) {
        Order order = orderService.receive(orderId);
        return R.ok(order);
    }

    @GetMapping("/getOrders")
    public R<Map<Long, Order>> getOrders() {
        Map<Long, Order> orders = orderService.getOrders();
        return R.ok(orders);
    }
}
