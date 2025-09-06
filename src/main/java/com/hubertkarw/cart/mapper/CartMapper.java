package com.hubertkarw.cart.mapper;

import com.hubertkarw.cart.model.Cart;
import com.hubertkarw.cart.model.CartCreateDTO;
import com.hubertkarw.cart.model.CartDTO;
import lombok.AllArgsConstructor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartMapper {
    CartDTO toDTO(Cart cart);
    Cart toEntity(CartCreateDTO cartCreateDTO);
    List<CartDTO> toDTOList(List<Cart> carts);
    List<Cart> toEntityList(List<CartDTO> cartDTOList);
}
