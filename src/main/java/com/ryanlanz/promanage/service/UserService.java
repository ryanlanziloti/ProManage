package com.ryanlanz.promanage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryanlanz.promanage.model.UsersModel;
import com.ryanlanz.promanage.model.DTO.UserDTO;
import com.ryanlanz.promanage.model.mapper.UserMapper;
import com.ryanlanz.promanage.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper mapper;

    //GET
    public UserDTO getUserWithTask(Long userId){
        UsersModel user = repository.findUserWithTasks(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));
        return mapper.toUserDTO(user);
    }

}
