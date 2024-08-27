package com.acc.orderservice.model.mapper;

import com.acc.orderservice.entity.Order;
import com.acc.orderservice.model.APIResponse;
import com.acc.orderservice.model.request.OrderRequest;
import com.acc.orderservice.model.response.OrderResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper extends APIResponseMapper<Order, OrderRequest, OrderResponse> {

    default APIResponse<OrderResponse> assignToApiResponseDto (OrderResponse s) {
        return new APIResponse<>(s);
    }

}
