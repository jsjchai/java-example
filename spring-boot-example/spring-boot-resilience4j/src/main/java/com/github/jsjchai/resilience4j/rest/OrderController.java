package com.github.jsjchai.resilience4j.rest;

import com.github.jsjchai.resilience4j.service.OrderService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeoutException;

/**
 * @author chaicj
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/saveOrder")
    public  String  saveOrder(){
        return orderService.saveOrder();
    }

    @GetMapping("/getOrder")
    public String getOrder(){
        return orderService.getOrder();
    }

    @GetMapping("/bulkhead")
    public String bulkhead(){
        return orderService.bulkhead();
    }

    @GetMapping("/retry")
    public String retry() throws TimeoutException {
        return orderService.retry();
    }
}
