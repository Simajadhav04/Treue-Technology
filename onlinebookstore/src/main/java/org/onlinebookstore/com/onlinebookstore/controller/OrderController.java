package org.onlinebookstore.com.onlinebookstore.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.onlinebookstore.com.onlinebookstore.dto.OrderDTO;
import org.onlinebookstore.com.onlinebookstore.entity.Book;
import org.onlinebookstore.com.onlinebookstore.entity.Order;
import org.onlinebookstore.com.onlinebookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController extends BaseController<Order>{

    @Autowired
    OrderService orderService;

    @Operation(summary = "Get Order By Userid")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order retrieved Successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Order.class))}),
            @ApiResponse(responseCode = "404", description = "Order Not Found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)})
    @GetMapping("/userid/{userId}")
    ResponseEntity<OrderDTO>getOrderByUserId(@PathVariable long userId){
        return ResponseEntity.ok(orderService.getOrderByUserId(userId));
    }
}
