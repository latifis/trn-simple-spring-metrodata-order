package com.acc.orderservice.service;

import com.acc.orderservice.model.APIResponse;
import com.acc.orderservice.model.request.OrderRequest;

public interface OrderService {

    APIResponse findAllOrder();
    APIResponse findOrderById(Long id);
    APIResponse addOrder(OrderRequest orderRequest);
    APIResponse updateOrder(Long id, OrderRequest orderRequest);
    APIResponse deleteOrder(Long id);

}
