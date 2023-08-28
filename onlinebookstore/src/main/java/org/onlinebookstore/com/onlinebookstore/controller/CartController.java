package org.onlinebookstore.com.onlinebookstore.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.onlinebookstore.com.onlinebookstore.dto.CartDTO;
import org.onlinebookstore.com.onlinebookstore.dto.CartUserDTO;
import org.onlinebookstore.com.onlinebookstore.entity.Book;
import org.onlinebookstore.com.onlinebookstore.entity.Cart;
import org.onlinebookstore.com.onlinebookstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController extends BaseController<Cart>{

    @Autowired
    private CartService cartService;

    @Operation(summary = "Get Cart By Userid")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cart retrieved Successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class))}),
            @ApiResponse(responseCode = "401", description = "User not allowed to retrieve the cart",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)})
    @GetMapping("/userId/{userId}")
    ResponseEntity<CartUserDTO> getCartsByUserId(@PathVariable long userId){
        return ResponseEntity.ok(cartService.getCartsByUserId(userId));
    }
}
