package com.acc.orderservice.service.impl;

import com.acc.orderservice.entity.Order;
import com.acc.orderservice.exception.CustomException;
import com.acc.orderservice.model.APIResponse;
import com.acc.orderservice.model.mapper.OrderMapper;
import com.acc.orderservice.model.request.OrderRequest;
import com.acc.orderservice.model.response.OrderResponse;
import com.acc.orderservice.repository.OrderRepository;
import com.acc.orderservice.service.OrderService;
import com.acc.orderservice.util.ObjectValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ObjectValidator<OrderRequest> objectValidator;

    @Override
    public APIResponse<List<OrderResponse>> findAllOrder() {
        return orderMapper.mapToApiResponseListDto(
                orderRepository.findAll()
        );
    }

    @Override
    public APIResponse<OrderResponse> findOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new CustomException(
                        String.format("Order with give id: %s not found", id),
                        "PRODUCT_NOT_FOUND",
                        404
                ));
        return orderMapper.mapToApiResponseDto(order);
    }

    @Override
    public APIResponse<OrderResponse> addOrder(OrderRequest orderRequest) {
        List<String> validate = objectValidator.validate(orderRequest);
        if (!validate.isEmpty()){
            return orderMapper.mapErrorToApiResponseDto(validate);
        }
        Order order = orderMapper.requestDtoToModel(orderRequest);
        return orderMapper.mapToApiResponseDto(
                orderRepository.save(order)
        );
    }

    @Override
    public APIResponse<OrderResponse> updateOrder(Long id, OrderRequest orderRequest) {

        List<String> validate = objectValidator.validate(orderRequest);
        if (!validate.isEmpty()){
            return orderMapper.mapErrorToApiResponseDto(validate);
        }

        findOrderById(id);
        Order order = orderMapper.requestDtoToModel(orderRequest);

        order.setId(id);  // agar bisa update
        return orderMapper.mapToApiResponseDto(
                orderRepository.saveAndFlush(order)
        );
    }

    @Override
    public APIResponse<OrderResponse> deleteOrder(Long id) {
        APIResponse<OrderResponse> order = findOrderById(id);
        orderRepository.deleteById(id);
        return order;
    }
}
