package org.onlinebookstore.com.onlinebookstore.service;

import org.onlinebookstore.com.onlinebookstore.entity.User;

import java.util.List;

public interface UserService extends  BaseService<User>{


    List<User> getUserByUserType(String userType);
}

