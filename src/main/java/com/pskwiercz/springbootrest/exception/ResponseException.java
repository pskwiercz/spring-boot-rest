package com.pskwiercz.springbootrest.exception;

import java.util.Date;

public class ResponseException extends RuntimeException {
    private Date timestamp;
    private String msg;
    private String details;

    public ResponseException(Date timestamp, String msg, String details) {
        this.timestamp = timestamp;
        this.msg = msg;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMsg() {
        return msg;
    }

    public String getDetails() {
        return details;
    }

    // Fix on DevTools to not print stack trace in REST response
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
