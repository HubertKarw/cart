package com.hubertkarw.cart.service;

import com.hubertkarw.cart.exception.CartAppException;
import com.hubertkarw.cart.mapper.CartMapper;
import com.hubertkarw.cart.model.Cart;
import com.hubertkarw.cart.model.CartCreateDTO;
import com.hubertkarw.cart.model.CartDTO;
import com.hubertkarw.cart.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository repository;
    private final CartMapper mapper;
    public List<CartDTO> getCarts() {
        return mapper.toDTOList(repository.findAll());
    }

    public CartDTO getCart(long id) {
        Cart cart = repository.findById(id)
                .orElseThrow(()->new CartAppException("cart not found", HttpStatus.NOT_FOUND));
        return mapper.toDTO(cart);
    }

    @Transactional
    public CartDTO createCart(CartCreateDTO cartCreateDTO) {
        return mapper.toDTO(repository.save(mapper.toEntity(cartCreateDTO)));
    }

    @Transactional
    public CartDTO updateCart(long id, CartCreateDTO customizationCreateDTO) {
        Cart cart = repository.findById(id)
                .orElseThrow(()->new CartAppException("cart not found", HttpStatus.NOT_FOUND));
        return mapper.toDTO(repository.save(cart));
    }

    public void deleteCart(long id) {
        Cart cart = repository.findById(id)
                .orElseThrow(()->new CartAppException("cart not found", HttpStatus.NOT_FOUND));
        repository.delete(cart);
    }
}
