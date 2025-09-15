package com.hubertkarw.cart.repository;

import com.hubertkarw.cart.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    @Query("SELECT ci FROM Cart c JOIN c.cartItems ci WHERE ci.id = :itemId AND c.id = :cartId")
    Optional<CartItem> findByIdAndCart_Id(@Param("itemId") Long itemId, @Param("cartId") Long cartId);
}
