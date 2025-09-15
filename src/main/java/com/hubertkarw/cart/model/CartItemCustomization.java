package com.hubertkarw.cart.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CART_ITEM_CUSTOMIZATION")
public class CartItemCustomization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "CART_ITEM_ID")
    private CartItem CartItem;

    public void setCart(Cart cart) {
        
    }
}
