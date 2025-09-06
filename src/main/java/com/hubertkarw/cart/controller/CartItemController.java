package com.hubertkarw.cart.controller;

import com.hubertkarw.cart.model.CartDTO;
import com.hubertkarw.cart.model.CartItem;
import com.hubertkarw.cart.model.CartItemDTO;
import com.hubertkarw.cart.service.CartItemService;
import com.hubertkarw.cart.service.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/carts/{id}/items")
public class CartItemController {

    private final CartItemService service;

    @Operation(summary = "Get cart items")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found cart items", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CartItemDTO.class))})
    })
    @GetMapping
    public List<CartItemDTO> getCartItems(@PathVariable long id) {
        log.info("GET /carts/{}/items requested", id);
        return service.getCartItems(id);
    }

    @Operation(summary = "Add cart item")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Added cart item", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CartItemDTO.class))})
    })
    @PostMapping("/add/{productId}")
    public CartItemDTO addCartItem(@PathVariable long id, @PathVariable long productId) {
        log.info("GET /carts/{}/items/add/{} requested", id, productId);
        return service.addCartItem(id, productId);
    }
    @Operation(summary = "Delete cart")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Removed cart")
    })
    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCartItem(@PathVariable long id, @PathVariable long productId){
        log.info("DELETE /carts/{}/items/{} requested", id, productId);
        service.deleteCartItem();
    }
}
