package com.ryanlanz.promanage.service;

import java.util.List;

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
    public List<UserDTO> getAll(){
        return mapper.toUserDTOList(repository.findAll());
    }

    public UserDTO getById(Long id){
        return mapper.toUserDTO(repository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id)));
    }

    //POST
    public UserDTO create(UserDTO userDTO){
        UsersModel userModel = mapper.toEntity(userDTO);
        return mapper.toUserDTO(repository.save(userModel));
    }

    //PUT
    public UserDTO update(UserDTO userDTO){
        UsersModel userModel = mapper.toEntity(userDTO);
        repository.findById(userModel.getId())
            .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userModel.getId()));
        return mapper.toUserDTO(repository.save(userModel));
    }

    //DELETE
    public boolean deleteUser(Long id){
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

}
