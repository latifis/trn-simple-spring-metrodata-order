package com.acc.orderservice.model.request;

import com.acc.orderservice.model.PaymentMode;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    @Min(value = 1, message = "Quantity should not be less than 1")
    private int quantity;

    @Min(value = 1, message = "Amount should not be empty")
    private long amount;

    @NotNull(message = "Payment mode should not be empty")
    private PaymentMode mode;

    @NotNull(message = "Product ID should not be empty")
    private Long productId;

}