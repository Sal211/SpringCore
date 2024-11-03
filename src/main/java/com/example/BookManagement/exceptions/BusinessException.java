package com.example.BookManagement.exceptions;

import lombok.Data;

@Data
public class BusinessException extends RuntimeException {
    private String code;

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(String code, String message, Throwable e) {
        super(message, e);
        this.code = code;
    }

    public BusinessException(String code, Throwable e) {
        super(e);
        this.code = code;
    }
}
