package org.onlinebookstore.com.onlinebookstore.service;

import org.onlinebookstore.com.onlinebookstore.entity.Address;
import org.onlinebookstore.com.onlinebookstore.exception.ResourceNotFoundException;
import org.onlinebookstore.com.onlinebookstore.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImp implements AddressService{
    @Autowired
    AddressRepository addressRepository;

    @Override
    public List<Address> getAllEntities() {
        return addressRepository.findAll();
    }

    @Override
    public Address createUpdateEntity(Address entity) {
        entity.setCreatedDate(new Date());
        return addressRepository.save(entity);
    }

    @Override
    public void deleteEntity(long id) {
        addressRepository.delete(getEntityById(id));

    }

    @Override
    public Address getEntityById(long id) {
        Optional<Address>addressOptional= addressRepository.findById(id);
        if(addressOptional.isPresent())
        {
            return addressOptional.get();
        }
        else {
            throw new ResourceNotFoundException("Address Not Found");
        }
    }

    @Override
    public List<Address> getAddressByUserId(long userId) {
        return addressRepository.findByUserId(userId);
    }
}
