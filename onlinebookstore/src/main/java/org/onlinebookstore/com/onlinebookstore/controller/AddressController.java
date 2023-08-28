package org.onlinebookstore.com.onlinebookstore.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.onlinebookstore.com.onlinebookstore.dto.AddressDTO;
import org.onlinebookstore.com.onlinebookstore.dto.CartUserDTO;
import org.onlinebookstore.com.onlinebookstore.entity.Address;
import org.onlinebookstore.com.onlinebookstore.entity.Book;
import org.onlinebookstore.com.onlinebookstore.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController extends BaseController<Address>{
    @Autowired
    AddressService addressService;

    @Operation(summary = "Get address by userid")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Address retrieved Successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class))}),
            @ApiResponse(responseCode = "404", description = "Address not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)})
    @GetMapping("/userid/{userId}")
    ResponseEntity<List<Address>> getAddressByUserId(@PathVariable long userId){
        return ResponseEntity.ok(addressService.getAddressByUserId(userId));
    }



    }
