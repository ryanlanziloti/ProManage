package com.ryanlanz.promanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;

import com.ryanlanz.promanage.model.DTO.UserDTO;
import com.ryanlanz.promanage.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService service;


    @GetMapping("/{userId}/with-task")
    public ResponseEntity<UserDTO>  findWithTask(@PathVariable Long userId){
        return ResponseEntity.ok(service.getUserWithTask(userId));
    }
}
