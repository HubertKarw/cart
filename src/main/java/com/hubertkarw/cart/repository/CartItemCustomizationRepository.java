package com.hubertkarw.cart.repository;

import com.hubertkarw.cart.model.CartItemCustomization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemCustomizationRepository extends JpaRepository<CartItemCustomization, Long> {
}
