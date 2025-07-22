package com.ryanlanz.promanage.model.mapper;

import org.mapstruct.Mapping;

import com.ryanlanz.promanage.model.TaskModel;
import org.mapstruct.Mapper; 
import org.mapstruct.NullValuePropertyMappingStrategy;
  
import com.ryanlanz.promanage.model.DTO.TaskDTO; 

@Mapper(componentModel = "spring", 
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TaskMapper {
    @Mapping(target = "id",source = "id")
    @Mapping(target = "userId",source = "user.id")
    @Mapping(target = "projectId",source = "project.id")
    TaskDTO toTaskDTO(TaskModel task);
 
    @Mapping(target = "id", source = "id")
    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "project.id", source = "projectId")
    TaskModel toEntity(TaskDTO taskDTO);
}
