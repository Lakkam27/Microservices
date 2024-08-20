package com.Akhil.Order_service.Exceptions;

import lombok.Data;

@Data
public class OrderServiceCustomException extends RuntimeException{

    private final String errorCode;
    private final int status;

    public OrderServiceCustomException(String message, String errorCode, int status) {
        super(message);
        this.errorCode = errorCode;
        this.status = status;
    }
}