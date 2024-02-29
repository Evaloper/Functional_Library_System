package com.library.exception;

public class NoUserOnQueueException extends RuntimeException{
    public NoUserOnQueueException(String message){
        super(message);
    }
}
