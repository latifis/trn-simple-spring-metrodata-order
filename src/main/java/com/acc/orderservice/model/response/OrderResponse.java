package com.acc.orderservice.model.response;

import com.acc.orderservice.model.PaymentMode;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    private int quantity;

    private long amount;

    private PaymentMode mode;

    private Long productId;

}
