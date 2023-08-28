package org.onlinebookstore.com.onlinebookstore.service;

import org.onlinebookstore.com.onlinebookstore.dto.CartDTO;
import org.onlinebookstore.com.onlinebookstore.dto.CartUserDTO;
import org.onlinebookstore.com.onlinebookstore.entity.Cart;
import org.onlinebookstore.com.onlinebookstore.exception.ResourceNotFoundException;
import org.onlinebookstore.com.onlinebookstore.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class CartServiceImp implements CartService{
    @Autowired
    CartRepository cartRepository;

    @Autowired
    BookService bookService;

    @Override
    public List<Cart> getAllEntities() {
        return cartRepository.findAll();
    }

    @Override
    public Cart createUpdateEntity(Cart entity) {
        entity.setCreatedDate(new Date());
        return cartRepository.save(entity);
    }

    @Override
    public void deleteEntity(long id) {
        cartRepository.delete(getEntityById(id));
        ResponseEntity.ok();

    }

    @Override
    public Cart getEntityById(long id) {
       Optional<Cart>cartOptional=cartRepository.findById(id);
       if(cartOptional.isPresent()) {
           return cartOptional.get();
       }
       else {
           throw new ResourceNotFoundException("cart not found");

       }
    }

    @Override
    public CartUserDTO getCartsByUserId(long userId) {
        List<Cart> carts = cartRepository.findByUserId(userId);
        List<CartDTO> cartDTOS=new ArrayList<>();
        carts.forEach(cart -> {
            var bookPrice = bookService.getBookByBookName(cart.getBookName()).getPrice();
            cartDTOS.add(CartDTO.builder().price(cart.getQuantity() * bookPrice).bookName(cart.getBookName()).quantity(cart.getQuantity()).build());
        });
        double totalPrice=0;
        for (CartDTO cartDTO : cartDTOS) {
            totalPrice = totalPrice + cartDTO.getPrice();
        }
        return CartUserDTO.builder().userId(userId).totalPrice(totalPrice).cartDTOList(cartDTOS).build();


    }
}
