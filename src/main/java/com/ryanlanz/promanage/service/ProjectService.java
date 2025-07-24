package com.ryanlanz.promanage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryanlanz.promanage.model.ProjectModel;
import com.ryanlanz.promanage.model.DTO.ProjectDTO;
import com.ryanlanz.promanage.model.mapper.ProjectMapper;
import com.ryanlanz.promanage.repository.ProjectRepository;

@Service
public class ProjectService {
    
    @Autowired
    private ProjectRepository repository;

    @Autowired
    private ProjectMapper mapper;

    //GET
    public List<ProjectDTO> getAll(){
        return mapper.toDTOProjectList(repository.findAll());
    }

    public ProjectDTO getById(Long id){
        return mapper.toDTOProjectDTO(repository.findById(id).orElseThrow());
    }

    //POST
    public ProjectDTO create(ProjectDTO projectDTO){
        ProjectModel projectModel = mapper.toEntityProjectModel(projectDTO);
        return mapper.toDTOProjectDTO(repository.save(projectModel));
    }

    //PUT
    public ProjectDTO update(ProjectDTO projectDTO){
        ProjectModel projectModel = mapper.toEntityProjectModel(projectDTO);
        repository.findById(projectModel.getId())
            .orElseThrow(() -> new RuntimeException("Project not found with id: " + projectModel.getId()));
        return mapper.toDTOProjectDTO(repository.save(projectModel));
    }

    //DELETE
    public boolean deleteProject(Long id){
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
