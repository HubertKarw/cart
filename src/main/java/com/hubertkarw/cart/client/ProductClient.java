package com.hubertkarw.cart.client;

import com.hubertkarw.cart.model.ProductClientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "cart")
public interface ProductClient {

    @GetMapping("/product/{id}")
    ProductClientDto getProductByID(@PathVariable long id);
}
