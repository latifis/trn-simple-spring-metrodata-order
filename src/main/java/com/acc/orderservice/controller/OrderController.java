package com.acc.orderservice.controller;

import com.acc.orderservice.entity.Order;
import com.acc.orderservice.model.APIResponse;
import com.acc.orderservice.model.request.OrderRequest;
import com.acc.orderservice.model.response.OrderResponse;
import com.acc.orderservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;

    @GetMapping
    public ResponseEntity<APIResponse<List<Order>>> getAllOrder() {
        return ResponseEntity.ok(orderService.findAllOrder());
    }

    // localhost:8085/api/v1/order/1 Pathvariable
    // localhost:8085/api/v1/order?id=1 RequestParam
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<OrderResponse>> getByOrderId(@PathVariable Long id) {
        return new ResponseEntity<>(orderService.findOrderById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<APIResponse<OrderResponse>> addOrder(@RequestBody OrderRequest orderRequest) {
        return new ResponseEntity<>(orderService.addOrder(orderRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<OrderResponse>> updateOrder(@PathVariable Long id, @RequestBody OrderRequest orderRequest) {
        return new ResponseEntity<>(orderService.updateOrder(id, orderRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<OrderResponse>> updateOrder(@PathVariable Long id) {
        return new ResponseEntity<>(orderService.deleteOrder(id), HttpStatus.OK);
    }

}
