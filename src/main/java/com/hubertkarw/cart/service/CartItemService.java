package com.hubertkarw.cart.service;

import com.hubertkarw.cart.exception.CartAppException;
import com.hubertkarw.cart.mapper.CartItemMapper;
import com.hubertkarw.cart.model.Cart;
import com.hubertkarw.cart.model.CartItem;
import com.hubertkarw.cart.model.CartItemCreateDTO;
import com.hubertkarw.cart.model.CartItemDTO;
import com.hubertkarw.cart.repository.CartItemRepository;
import com.hubertkarw.cart.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartItemService {

    private final CartItemMapper mapper;
    private final CartRepository cartRepository;
    private final CartItemRepository repository;

    public List<CartItemDTO> getCartItems(long id) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new CartAppException("Cart not found", HttpStatus.NOT_FOUND));
        return mapper.toDTOList(cart.getCartItems());
    }

    public CartItemDTO getCartItem(long id, long itemId) {
        CartItem item = repository.findByIdAndCart_Id(itemId, id)
                .orElseThrow(() -> new CartAppException("Item not found in this cart", HttpStatus.NOT_FOUND));
        return mapper.toDto(item);
    }

    public CartItemDTO addCartItem(long id, CartItemCreateDTO cartItemCreateDTO) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new CartAppException("Cart not found", HttpStatus.NOT_FOUND));
        CartItem cartItem = mapper.toEntity(cartItemCreateDTO);
        cartItem.getCustomizations().forEach(customization -> customization.setCart(cart));
        cartItem.setCart(cart);
        cart.getCartItems().add(cartItem);
        BigDecimal price = cartItem.getPrice();
        BigDecimal customizationPrice = cartItem.getCustomizations().stream()
                .map(custom -> custom.getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        cart.setPrice(cart.getPrice().add(price).add(customizationPrice));
        Cart savedCart = cartRepository.save(cart);
        return mapper.toDto(savedCart.getCartItems().getLast());
    }

    public void deleteCartItem(long id, long itemId) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new CartAppException("Cart not found", HttpStatus.NOT_FOUND));
        CartItem item = repository.findByIdAndCart_Id(itemId, id)
                .orElseThrow(() -> new CartAppException("Item not found in this cart", HttpStatus.NOT_FOUND));
        repository.delete(item);
    }
}
