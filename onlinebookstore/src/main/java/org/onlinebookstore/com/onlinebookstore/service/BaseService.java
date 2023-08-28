package org.onlinebookstore.com.onlinebookstore.service;

import org.onlinebookstore.com.onlinebookstore.entity.BaseEntity;
import org.onlinebookstore.com.onlinebookstore.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BaseService<T extends BaseEntity>{


    List<T> getAllEntities();

    T createUpdateEntity(T entity);

    void deleteEntity(long id);

    T getEntityById(long id);


}
