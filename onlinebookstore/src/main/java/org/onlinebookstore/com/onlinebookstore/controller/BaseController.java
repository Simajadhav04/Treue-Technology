package org.onlinebookstore.com.onlinebookstore.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.onlinebookstore.com.onlinebookstore.entity.BaseEntity;
import org.onlinebookstore.com.onlinebookstore.entity.Book;
import org.onlinebookstore.com.onlinebookstore.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BaseController<T extends BaseEntity> {

    @Autowired
    private BaseService<T> baseService;

    @Operation(summary = "Get all entity")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entity retrieved Successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class))}),
            @ApiResponse(responseCode = "401", description = "User not allowed to retrieve the entity",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)})
    @GetMapping()
    public ResponseEntity<List<T>> getAllEntities(){
        return ResponseEntity.ok().body(baseService.getAllEntities());
    }

    @Operation(summary = "Get entity by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entity Retrieved Successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class))}),
            @ApiResponse(responseCode = "401", description = "User not allowed to retrieved the entity",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)})
    @GetMapping("/{id}")
    public ResponseEntity<T> getEntityById(@PathVariable long id){
        return ResponseEntity.ok().body(baseService.getEntityById(id));
    }

    @Operation(summary = "Create a new entity")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entity Created Successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class))}),
            @ApiResponse(responseCode = "401", description = "User not allowed to create entity",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)})
    @PostMapping()
    public ResponseEntity<T> createUpdateEntity(@RequestBody @Valid T entity){
        return ResponseEntity.ok().body(this.baseService.createUpdateEntity(entity));
    }

    @Operation(summary = "Delete entity by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entity Deleted Successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class))}),
            @ApiResponse(responseCode = "401", description = "User not allowed to delete entity",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)})
    @DeleteMapping("/{id}")
    public HttpStatus deleteUser(@PathVariable long id){
        this.baseService.deleteEntity(id);
        return HttpStatus.OK;
    }
}
