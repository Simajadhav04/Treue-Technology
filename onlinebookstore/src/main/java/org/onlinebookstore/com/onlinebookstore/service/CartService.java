package org.onlinebookstore.com.onlinebookstore.service;

import org.onlinebookstore.com.onlinebookstore.dto.CartDTO;
import org.onlinebookstore.com.onlinebookstore.dto.CartUserDTO;
import org.onlinebookstore.com.onlinebookstore.entity.Cart;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService extends BaseService<Cart> {
    CartUserDTO getCartsByUserId(long userId);
}
