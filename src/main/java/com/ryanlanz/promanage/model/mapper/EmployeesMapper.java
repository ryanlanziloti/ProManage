package com.ryanlanz.promanage.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
//import org.mapstruct.factory.Mappers;

import com.ryanlanz.promanage.model.EmployeesModel;
import com.ryanlanz.promanage.model.DTO.EmployeesDTO;
 

@Mapper(componentModel = "spring", 
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EmployeesMapper {

    //EmployeesMapper INSTANCE = Mappers.getMapper(EmployeesMapper.class);

    @Mapping(target = "userId", source = "user.id")
    EmployeesDTO toDTO(EmployeesModel employee);

    default List<EmployeesDTO> toDTOList(List<EmployeesModel> employees){
        return employees.stream().map(this::toDTO).toList();
    }

    @Mapping(target = "user", ignore = true)
    EmployeesModel toEntity(EmployeesDTO employeesDTO);
}
