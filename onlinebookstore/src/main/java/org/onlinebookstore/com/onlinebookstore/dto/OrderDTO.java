package org.onlinebookstore.com.onlinebookstore.dto;

import lombok.Builder;
import lombok.Data;
import org.onlinebookstore.com.onlinebookstore.entity.Address;

import java.util.List;

@Data
@Builder
public class OrderDTO {
    private long userId;
    private double totalPrice;
    List<BookDTO>bookDTOList;
    Address address;
}
