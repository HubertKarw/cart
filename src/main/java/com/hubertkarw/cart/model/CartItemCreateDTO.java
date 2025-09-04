package com.hubertkarw.cart.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemCreateDTO {
    private String name;
    private String type;
    private BigDecimal price;
}
