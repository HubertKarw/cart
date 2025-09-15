package com.hubertkarw.cart.controller;

import com.hubertkarw.cart.model.CartCreateDTO;
import com.hubertkarw.cart.model.CartDTO;
import com.hubertkarw.cart.service.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/carts")
public class CartController {

    private final CartService service;

    @Operation(summary = "Get carts")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found carts", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CartDTO.class))})
    })
    @GetMapping()
    public List<CartDTO> getCarts() {
        log.info("GET /carts requested");
        return service.getCarts();
    }

    @Operation(summary = "Get Cart by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found Cart", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CartDTO.class))})
    })
    @GetMapping("/{id}")
    public CartDTO getCart(@PathVariable long id) {
        log.info("GET /carts/{} requested", id);
        return service.getCart(id);
    }

    @Operation(summary = "Create Cart")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created cart", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CartDTO.class))})
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CartDTO createCart(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Cart to create",
            required = true,
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = CartCreateDTO.class),
                    examples = @ExampleObject(value =
                            """
                                    {
                                    "name": "MyCart",
                                    "discountCode": "XYZ-12-10"
                                    }
                                    """)))
                              @RequestBody CartCreateDTO cartCreateDTO) {
        log.info("POST /carts requested body={}", cartCreateDTO);
        return service.createCart(cartCreateDTO);
    }

    @Operation(summary = "Delete cart")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Removed cart")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCart(@PathVariable long id) {
        log.info("DELETE /carts/{} requested", id);
        service.deleteCart(id);
    }

}
