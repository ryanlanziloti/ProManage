package com.ryanlanz.promanage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryanlanz.promanage.model.mapper.TeamMapper;
import com.ryanlanz.promanage.repository.TeamRepository;
import com.ryanlanz.promanage.model.TeamModel;
import com.ryanlanz.promanage.model.DTO.TeamDTO;

@Service
public class TeamService {
    
    @Autowired
    private TeamRepository repository;

    @Autowired
    private TeamMapper mapper;

    //GET
    public List<TeamDTO> getAll(){
        return mapper.toDTOList(repository.findAll());
    }

    public TeamDTO getById(Long id){
        return mapper.toDTO(repository.findById(id).orElseThrow());
    }
    //POST
    public TeamDTO create(TeamDTO teamDTO){
        TeamModel teamModel = mapper.toEntity(teamDTO);
        return mapper.toDTO(repository.save(teamModel));
    }

    //PUT
    public TeamDTO update(TeamDTO teamDTO){
        TeamModel teamModel = mapper.toEntity(teamDTO);
        repository.findById(teamModel.getId())
            .orElseThrow(() -> new RuntimeException("Team not found with id: " + teamModel.getId()));
        return mapper.toDTO(repository.save(teamModel));
    }

    //DELETE
    public boolean deleteTeam(Long id){
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

}
