package com.acc.orderservice.external.client;

import com.acc.orderservice.model.APIResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PRODUCT-SERVICE", path = "/api/v1/products")
public interface ProductService {

    @GetMapping("/checkAvailable/{id}")
    public void checkAvailability(@PathVariable Long id,
                                  @RequestParam int quantity);

    @PutMapping("/reduceQuantity/{id}")
    public void reduceQuantity(@PathVariable Long id,
                               @RequestParam int quantity);

}
