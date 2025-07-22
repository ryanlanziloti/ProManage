package com.ryanlanz.promanage.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
 
import com.ryanlanz.promanage.model.UsersModel; 
import com.ryanlanz.promanage.model.DTO.UserDTO;

@Mapper(componentModel = "spring", 
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper extends TaskMapper{
    
    @Mapping(target = "employeeId", source = "employee.id")
    @Mapping(target = "tasks",source = "tasks")
    UserDTO toUserDTO(UsersModel user);

    @Mapping(target = "createdProjects", ignore = true)
    @Mapping(target = "tasks", ignore = true)
    @Mapping(target = "teamMemberships", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "employee", ignore = true)
    UsersModel toEntity(UserDTO userDTO);

}
