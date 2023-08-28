package org.onlinebookstore.com.onlinebookstore.repository;

import org.onlinebookstore.com.onlinebookstore.entity.BaseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface BaseRepository<T extends BaseEntity> extends MongoRepository<T, Serializable> {

}
