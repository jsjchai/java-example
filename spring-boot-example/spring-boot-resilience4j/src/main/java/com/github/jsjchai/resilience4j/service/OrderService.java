package com.github.jsjchai.resilience4j.service;

public interface OrderService {

    String saveOrder();

    String getOrder();

    String bulkhead();
}
