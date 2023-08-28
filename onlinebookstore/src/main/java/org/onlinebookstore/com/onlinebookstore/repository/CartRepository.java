package org.onlinebookstore.com.onlinebookstore.repository;

import org.onlinebookstore.com.onlinebookstore.entity.Cart;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends BaseRepository<Cart>{
    List<Cart> findByUserId(long userId);
}
