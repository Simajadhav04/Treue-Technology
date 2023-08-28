package org.onlinebookstore.com.onlinebookstore.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.onlinebookstore.com.onlinebookstore.entity.Book;
import org.onlinebookstore.com.onlinebookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController extends BaseController<Book> {

    @Autowired
    BookService bookService;

    @Operation(summary = "Create a new book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book Created Successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class))}),
            @ApiResponse(responseCode = "401", description = "User not allowed to create book",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)})
    @PostMapping("/userid/{userId}")
    ResponseEntity<Book> insertBook(@PathVariable long userId, @RequestBody Book book) {
        return ResponseEntity.ok(bookService.insertBook(userId, book));
    }

    @Operation(summary = "Delete the book by book id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book Deleted Successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class))}),
            @ApiResponse(responseCode = "401", description = "User not allowed to delete book",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)})
    @DeleteMapping("{bookId}/user/{userId}")
    ResponseEntity<String> deleteBook(@PathVariable String bookId, @PathVariable long userId) {
        return ResponseEntity.ok(bookService.deleteBook(userId, bookId));
    }

    @Operation(summary = "Search the book by book name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book retrieved Successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class))}),
            @ApiResponse(responseCode = "404", description = "Book Not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)})
    @GetMapping("/searchBook")
    ResponseEntity<Book> searchBookByName(@RequestParam String bookName) {
        return ResponseEntity.ok(bookService.getBookByBookName(bookName));
    }

    @Operation(summary = "Search the book by book category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Books retrieved Successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class))}),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)})
    @GetMapping("/searchBooks")
    ResponseEntity<List<Book>> searchBookByCategory(@RequestParam String category) {
        return ResponseEntity.ok(bookService.getBookByCategory(category).stream().toList());
    }

}
