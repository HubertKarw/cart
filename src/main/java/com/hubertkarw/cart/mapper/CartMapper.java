package com.hubertkarw.cart.mapper;

import com.hubertkarw.cart.model.Cart;
import com.hubertkarw.cart.model.CartCreateDTO;
import com.hubertkarw.cart.model.CartDTO;
import lombok.AllArgsConstructor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper {
    CartDTO toDTO(Cart cart);
    Cart toEntity(CartCreateDTO cartCreateDTO);
}
