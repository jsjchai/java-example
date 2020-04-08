package com.github.jsjchai.resilience4j.service;

import java.util.concurrent.TimeoutException;

/**
 * @author jsjchai
 */
public interface OrderService {

    String saveOrder();

    String getOrder();

    String bulkhead();

    String retry() throws TimeoutException;
}
