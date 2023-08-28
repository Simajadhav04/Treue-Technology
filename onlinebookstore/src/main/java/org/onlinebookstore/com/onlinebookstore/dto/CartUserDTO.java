package org.onlinebookstore.com.onlinebookstore.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CartUserDTO {
    private long userId;
    List<CartDTO> cartDTOList;
    private double totalPrice;
}
