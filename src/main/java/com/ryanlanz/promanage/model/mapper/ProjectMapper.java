package com.ryanlanz.promanage.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.ryanlanz.promanage.model.ProjectModel;
import com.ryanlanz.promanage.model.DTO.ProjectDTO;

@Mapper(componentModel = "spring", 
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProjectMapper {
     
    ProjectDTO toDTO(ProjectModel projectModel);

}
