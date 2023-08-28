package org.onlinebookstore.com.onlinebookstore.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.onlinebookstore.com.onlinebookstore.dto.UserDTO;
import org.onlinebookstore.com.onlinebookstore.entity.Book;
import org.onlinebookstore.com.onlinebookstore.entity.User;
import org.onlinebookstore.com.onlinebookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController<User> {
	
	@Autowired
	private UserService userservice;

	@Operation(summary = "Get User by User Type")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "User Retrieved Successfully",
					content = {@Content(mediaType = "application/json",
							schema = @Schema(implementation = User.class))}),
			@ApiResponse(responseCode = "404", description = "User Not Found",
					content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error",
					content = @Content)})
	@GetMapping("/userType")
	public ResponseEntity<List<User>> getUserByUserType(@RequestParam String userType){
		return ResponseEntity.ok().body(userservice.getUserByUserType(userType).stream().toList());
	}

}
