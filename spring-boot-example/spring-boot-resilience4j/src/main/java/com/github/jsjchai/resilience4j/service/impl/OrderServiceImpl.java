package com.github.jsjchai.resilience4j.service.impl;

import com.github.jsjchai.resilience4j.exception.DBException;
import com.github.jsjchai.resilience4j.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author chaicj
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    /**
     *  服务熔断，当抛出DBException，回调fallback方法
     * @return String
     */
    @Override
    @CircuitBreaker(name = "order",fallbackMethod = "fallback")
    public String saveOrder() {
        throw new DBException("db exception");
    }

    private String fallback(Exception e){
        log.info("fallback exception",e);
        return "00000000000";
    }
}
