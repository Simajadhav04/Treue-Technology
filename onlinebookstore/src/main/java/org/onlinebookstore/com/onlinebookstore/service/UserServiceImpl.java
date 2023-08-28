package org.onlinebookstore.com.onlinebookstore.service;


import org.onlinebookstore.com.onlinebookstore.entity.User;
import org.onlinebookstore.com.onlinebookstore.exception.ResourceNotFoundException;
import org.onlinebookstore.com.onlinebookstore.repository.BookRepository;
import org.onlinebookstore.com.onlinebookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    BookRepository bookRepository;


    @Override
    public List<User> getAllEntities() {
        return userRepository.findAll();
    }

    @Override
    public User createUpdateEntity(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public void deleteEntity(long id) {
        userRepository.delete(getEntityById(id));

    }

    @Override
    public User getEntityById(long id) {
        return userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found"));
    }

    @Override
    public List<User> getUserByUserType(String userType) {
        return userRepository.findByUserType(userType);
    }
}



