package org.onlinebookstore.com.onlinebookstore.entity;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DocumentReference;


@Getter
@Setter
@NoArgsConstructor
@Document (collection = "user")
public class User extends BaseEntity{

	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";

	@NotBlank
	@Size(min = 0, max = 50)
	@Indexed(unique = true)
	private long userId;

	@NotBlank
	@Size(min = 0, max = 50)
	@Indexed(unique = true)
	private String userName;

	@NotBlank
	@Size(min = 0, max = 10)
	@Indexed(unique = true)
	private String password;

	@NotBlank
	@Size(min = 0, max = 20)
	@Indexed(unique = true)
	private String userType;

	@NotBlank
	@Size(min = 0, max = 20)
	@Indexed(unique = true)
	private String mailId;

}
