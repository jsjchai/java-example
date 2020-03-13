package com.github.jsjchai.resilience4j.service;

import com.github.jsjchai.resilience4j.Resilience4jApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Resilience4jApplication.class)
@Slf4j
class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    void bulkhead() throws InterruptedException {

        int len = 10;
        Thread[] threads = new Thread[len];
        CountDownLatch latch = new CountDownLatch(len);
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                String result = orderService.bulkhead();
                log.info("result:{}", result);
                latch.countDown();
            });
            threads[i].start();
        }

        latch.await();
    }
}