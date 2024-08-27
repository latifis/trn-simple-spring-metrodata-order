package com.acc.orderservice.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class APIResponse<T>{

    private String status;
    private List<String> message = new ArrayList<String>();
    private T data;

    public APIResponse(T data) {
        this.status = CommonStatus.SUCCESS.name();
        this.data = data;
    }

    public APIResponse(List<String> message) {
        this.status = CommonStatus.FAILED.name();
        this.message = message;
    }
}
