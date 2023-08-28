package org.onlinebookstore.com.onlinebookstore.entity;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.onlinebookstore.com.onlinebookstore.dto.BookDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "order")
public class Order extends BaseEntity {
    private String bookName;
    private int quantity;
    private double price;
    private long userId;

}
