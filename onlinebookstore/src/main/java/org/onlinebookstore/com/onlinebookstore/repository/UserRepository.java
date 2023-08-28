package org.onlinebookstore.com.onlinebookstore.repository;

import org.onlinebookstore.com.onlinebookstore.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends BaseRepository<User> {

    List<User>findByUserType(String userType);

    Optional<User> findByUserId(long userId);
}
