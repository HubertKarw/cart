package com.hubertkarw.cart.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class CartAppException extends RuntimeException{

    private LocalDateTime timestamp;
    private HttpStatus status;

    public CartAppException(String message, HttpStatus status) {
        super(message);
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }
}
