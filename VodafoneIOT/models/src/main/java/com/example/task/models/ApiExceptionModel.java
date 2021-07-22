package com.example.task.models;

public class ApiExceptionModel {
    private String errorId;
    private String errorCode;
    private String error;
    private String message;

    private ApiExceptionModel() {
    }

    public ApiExceptionModel(ApiException exception) {
        this.errorId = exception.getErrorId();
        this.errorCode = exception.getErrorCode();
        this.error = exception.getMessage();
    }

}
