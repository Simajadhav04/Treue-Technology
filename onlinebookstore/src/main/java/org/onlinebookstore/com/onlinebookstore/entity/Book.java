package org.onlinebookstore.com.onlinebookstore.entity;


import jakarta.persistence.Index;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.onlinebookstore.com.onlinebookstore.enums.Category;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
@Getter
@Setter
@NoArgsConstructor
@Document (collection = "book")
public class Book extends BaseEntity {
	@Serial
	private static final long serialVersionUID = -382328198872299791L;
	@NotBlank
	@Indexed(unique = true)
	private String bookName;
	private String author;
	private double price;
	private int quantity;
	private String description;
	private Category category;
	private boolean available;
}
