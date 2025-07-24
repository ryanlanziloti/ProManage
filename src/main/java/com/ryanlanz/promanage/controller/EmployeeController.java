package com.ryanlanz.promanage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ryanlanz.promanage.model.DTO.EmployeesDTO;
import com.ryanlanz.promanage.service.EmployeesService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    
    @Autowired
    private EmployeesService service;

    //GET
    @GetMapping
    public ResponseEntity<List<EmployeesDTO>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeesDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }
    
    //POST
    @PostMapping
    public ResponseEntity<EmployeesDTO> create(@RequestBody EmployeesDTO employeesDTO){
        return ResponseEntity.ok(service.create(employeesDTO));
    }

    //PUT
    @PutMapping
    public ResponseEntity<EmployeesDTO> update(@RequestBody EmployeesDTO employeesDTO){
        return ResponseEntity.ok(service.update(employeesDTO));
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable Long id){
        return ResponseEntity.ok(service.deleteEmployee(id));
    }
}
