package com.hubertkarw.cart.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {
    private Long id;
    private String name;
    private String discountCode;
    private BigDecimal price;
    private List<CartItemDTO> cartItems;
}
