package com.hubertkarw.cart.mapper;

import com.hubertkarw.cart.model.CartItemCustomization;
import com.hubertkarw.cart.model.CartItemCustomizationCreateDTO;
import com.hubertkarw.cart.model.CartItemCustomizationDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartItemCustomizationMapper {
    CartItemCustomizationDTO toDTO(CartItemCustomization customization);
    CartItemCustomization toEntity(CartItemCustomizationCreateDTO customizationCreateDTO);
    List<CartItemCustomizationDTO> toDTOList (List<CartItemCustomization> customizations);
    List<CartItemCustomization> toEntityList (List<CartItemCustomizationCreateDTO> customizationsCreateDTO);
}
