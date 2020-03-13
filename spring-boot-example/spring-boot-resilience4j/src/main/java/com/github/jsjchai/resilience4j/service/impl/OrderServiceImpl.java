package com.github.jsjchai.resilience4j.service.impl;

import com.github.jsjchai.resilience4j.exception.BusinessException;
import com.github.jsjchai.resilience4j.exception.DBException;
import com.github.jsjchai.resilience4j.service.OrderService;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author chaicj
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private static final String CIRCUIT_NAME = "order";

    /**
     * 服务熔断，当抛出DBException，回调fallback方法
     *
     * @return String
     */
    @Override
    @CircuitBreaker(name = CIRCUIT_NAME, fallbackMethod = "fallback")
    public String saveOrder() {
        throw new DBException("record db exception");
    }

    @Override
    @CircuitBreaker(name = CIRCUIT_NAME)
    public String getOrder() {
        throw new BusinessException("ignore business exception");
    }

    @Override
    @Bulkhead(name = CIRCUIT_NAME, fallbackMethod = "bulkheadFallback", type = Bulkhead.Type.SEMAPHORE)
    public String bulkhead() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "success";
    }


    private static Integer num = 1;

    @Override
    @Retry(name = CIRCUIT_NAME)
    public String retry() throws TimeoutException {
        log.info("retry start");
        if(num == 1){
            num = 0;
            throw new TimeoutException();
        }else{
            num = 1;
        }
        log.info("retry end");
        return "success";
    }

    private String fallback( Exception e ) {
        log.info("fallback exception", e);
        return "00000000000";
    }

    private String bulkheadFallback( Exception e ) {
        log.info("limit the number of concurrent execution", e);
        return "thread bulkhead";
    }
}
