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

import com.ryanlanz.promanage.model.DTO.TeamDTO;
import com.ryanlanz.promanage.service.TeamService;
 

@RestController
@RequestMapping("/team")
public class TeamController {
    
    @Autowired
    private TeamService service;

    //GET 
    @GetMapping
    public ResponseEntity<List<TeamDTO>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }
    
    //POST
    @PostMapping
    public ResponseEntity<TeamDTO> create(@RequestBody TeamDTO teamDTO){
        return ResponseEntity.ok(service.create(teamDTO));
    }

    //PUT
    @PutMapping
    public ResponseEntity<TeamDTO> update(@RequestBody TeamDTO teamDTO){
        return ResponseEntity.ok(service.update(teamDTO));
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTeam(@PathVariable Long id){
        return ResponseEntity.ok(service.deleteTeam(id));
    }
}
