package com.acc.orderservice.exception;

import lombok.Data;

@Data
public class CustomException extends RuntimeException {

    private int status; // Status Code
    private String error;// PRODUCT_NOT_FOUND

    public CustomException(String message, String error, int status) {
        super(message);
        this.status = status;
        this.error = error;
    }
}
