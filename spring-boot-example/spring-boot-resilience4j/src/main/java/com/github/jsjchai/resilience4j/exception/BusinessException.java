package com.github.jsjchai.resilience4j.exception;

/**
 * @author jsjchai
 */
public class BusinessException extends RuntimeException {

    public BusinessException( String message) {
        super(message);
    }
}
