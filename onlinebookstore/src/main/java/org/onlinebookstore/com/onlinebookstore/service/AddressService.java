package org.onlinebookstore.com.onlinebookstore.service;

import org.onlinebookstore.com.onlinebookstore.entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService extends BaseService<Address>{


     List<Address> getAddressByUserId(long userId);
}
