package com.github.jsjchai.resilience4j.exception;

/**
 * @author chaicj
 */
public class DBException extends RuntimeException{

    public DBException( String message ) {
        super(message);
    }
}
