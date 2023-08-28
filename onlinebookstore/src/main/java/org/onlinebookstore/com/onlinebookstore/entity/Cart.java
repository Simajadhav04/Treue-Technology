package org.onlinebookstore.com.onlinebookstore.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "cart")
public class Cart extends BaseEntity {
    private String bookName;
    private int quantity;
    private long userId;
}
