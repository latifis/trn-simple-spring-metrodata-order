package com.acc.orderservice.service;

import com.acc.orderservice.model.APIResponse;
import com.acc.orderservice.model.request.OrderRequest;
import com.acc.orderservice.model.response.OrderResponse;

import java.util.List;

public interface OrderService {

    APIResponse<List<OrderResponse>> findAllOrder();
    APIResponse<OrderResponse> findOrderById(Long id);
    APIResponse<OrderResponse> addOrder(OrderRequest orderRequest);
    APIResponse<OrderResponse> updateOrder(Long id, OrderRequest orderRequest);
    APIResponse<OrderResponse> deleteOrder(Long id);

}
