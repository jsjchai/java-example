package com.github.jsjchai.resilience4j.exception;

/**
 * @author jsjchai
 */
public class DBException extends RuntimeException{

    public DBException( String message ) {
        super(message);
    }
}
