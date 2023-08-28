package org.onlinebookstore.com.onlinebookstore.repository;

import org.onlinebookstore.com.onlinebookstore.entity.Order;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends BaseRepository<Order>{
    @Override
    Optional<Order> findById(Serializable serializable);

    List<Order> findByUserId(long userId);
}
