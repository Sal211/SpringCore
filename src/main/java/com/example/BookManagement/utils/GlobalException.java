package com.example.BookManagement.utils;
import com.example.BookManagement.exceptions.BusinessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(BusinessException.class)
    public BaseRespone handleResourceNotFoundException(BusinessException ex) {
        return BaseRespone.builder()
                .code(ex.getCode())
                .Data(ex.getMessage())
                .build();
    }
}
