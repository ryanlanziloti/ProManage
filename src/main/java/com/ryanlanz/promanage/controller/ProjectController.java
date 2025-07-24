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

import com.ryanlanz.promanage.model.DTO.ProjectDTO;
import com.ryanlanz.promanage.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {
    
    @Autowired
    private ProjectService service;

    //GET
    @GetMapping
    public ResponseEntity<List<ProjectDTO>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }
    
    //POST
    @PostMapping
    public ResponseEntity<ProjectDTO> create(@RequestBody ProjectDTO project){
        return ResponseEntity.ok(service.create(project));
    }

    //PUT
    @PutMapping
    public ResponseEntity<ProjectDTO> update(@RequestBody ProjectDTO project){
        return ResponseEntity.ok(service.update(project));
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProject(@PathVariable Long id){
        return ResponseEntity.ok(service.deleteProject(id));
    }
}
