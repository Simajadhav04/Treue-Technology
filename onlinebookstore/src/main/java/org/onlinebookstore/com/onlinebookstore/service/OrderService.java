package org.onlinebookstore.com.onlinebookstore.service;

import org.onlinebookstore.com.onlinebookstore.dto.BookDTO;
import org.onlinebookstore.com.onlinebookstore.dto.OrderDTO;
import org.onlinebookstore.com.onlinebookstore.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService extends BaseService<Order> {

    OrderDTO getOrderByUserId(long userId);
}
