package com.github.jsjchai.resilience4j.service.impl;

import com.github.jsjchai.resilience4j.exception.DBException;
import com.github.jsjchai.resilience4j.service.OrderService;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author chaicj
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    @CircuitBreaker(name = "orderCircuitBreaker")
    @Bulkhead(name = "orderCircuitBreaker")
    @Retry(name = "orderCircuitBreaker")
    public String saveOrder() {
        throw new DBException();
    }
}
