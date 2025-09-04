package com.hubertkarw.cart.mapper;

import com.hubertkarw.cart.model.CartItem;
import com.hubertkarw.cart.model.CartItemCreateDTO;
import com.hubertkarw.cart.model.CartItemDTO;
import com.hubertkarw.cart.model.ProductClientDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartItemMapper {
    CartItemDTO toDto(CartItem cartItem);
    CartItem toEntity(CartItemCreateDTO cartItemCreateDTO);
    List<CartItemDTO> toDTOList(List<CartItem> cartItems);
    List<CartItem> toEntityList(List<CartItemCreateDTO> cartItemsCreateDTO);

}
