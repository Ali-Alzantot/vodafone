package com.example.task.models;

import java.util.UUID;

public class ApiException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String errorId;
    private String errorCode;

    public ApiException(String errorCode) {
        super(errorCode);
        this.errorId = uuid();
        this.errorCode = errorCode;
    }

    public ApiException(String errorCode, String message) {
        super(message);
        this.errorId = uuid();
        this.errorCode = errorCode;
    }

    public ApiException(String errorCode, String message, Throwable ex) {
        super(message, ex);
        this.errorId = uuid();
        this.errorCode = errorCode;
    }

    public String getErrorId() {
        return this.errorId;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorId(String errorId) {
        this.errorId = errorId;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public ApiException() {
    }

    private String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
