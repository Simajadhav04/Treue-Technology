package org.onlinebookstore.com.onlinebookstore.service;

import org.onlinebookstore.com.onlinebookstore.dto.BookDTO;
import org.onlinebookstore.com.onlinebookstore.dto.CartDTO;
import org.onlinebookstore.com.onlinebookstore.dto.CartUserDTO;
import org.onlinebookstore.com.onlinebookstore.dto.OrderDTO;
import org.onlinebookstore.com.onlinebookstore.entity.Book;
import org.onlinebookstore.com.onlinebookstore.entity.Cart;
import org.onlinebookstore.com.onlinebookstore.entity.Order;
import org.onlinebookstore.com.onlinebookstore.exception.ResourceNotFoundException;
import org.onlinebookstore.com.onlinebookstore.repository.AddressRepository;
import org.onlinebookstore.com.onlinebookstore.repository.BookRepository;
import org.onlinebookstore.com.onlinebookstore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImp implements OrderService{
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    BookService bookService;
    @Autowired
    AddressRepository addressRepository;
    @Override
    public List<Order> getAllEntities() {
        return orderRepository.findAll();
    }

    @Override
    public Order createUpdateEntity(Order entity) {
        entity.setCreatedDate(new Date());
        return orderRepository.insert(entity);
    }

    @Override
    public void deleteEntity(long id) {
        orderRepository.delete(getEntityById(id));

    }

    @Override
    public Order getEntityById(long id) {
        Optional<Order>orderOptional=orderRepository.findById(id);

        if(orderOptional.isPresent())
        {
            return orderOptional.get();

        }
        else {
            throw new ResourceNotFoundException("Order Not Found!!!");
        }

    }


    @Override
    public OrderDTO getOrderByUserId(long userId) {
        List<Order> orders =orderRepository.findByUserId(userId);
        List<BookDTO> bookDTOS=new ArrayList<>();
        orders.forEach(order -> {
            var bookPrice = bookService.getBookByBookName(order.getBookName()).getPrice();
            bookDTOS.add(BookDTO.builder().price(order.getQuantity() * bookPrice).bookName(order.getBookName()).quantity(order.getQuantity()).build());
        });
        double totalPrice=0;
        for (BookDTO bookDTO : bookDTOS) {
            totalPrice = totalPrice + bookDTO.getPrice();
        }
        var address = addressRepository.findByUserId(userId).get(0);
        return OrderDTO.builder().userId(userId).totalPrice(totalPrice).bookDTOList(bookDTOS).address(address).build();
    }
}
