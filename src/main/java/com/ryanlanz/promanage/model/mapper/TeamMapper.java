package com.ryanlanz.promanage.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
 
import com.ryanlanz.promanage.model.TeamModel;
import com.ryanlanz.promanage.model.UsersModel;
import com.ryanlanz.promanage.model.DTO.TeamDTO;

@Mapper(componentModel = "spring", 
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TeamMapper extends TeamUsersMapper {
    
    @Mapping(target = "managedBy", source = "managedBy.id")
    @Mapping(target = "createdBy", source = "createdBy.id")
    @Mapping(target = "members", source = "members")
    TeamDTO toDTO(TeamModel team);

    @Mapping(target = "managedBy", source = "managedBy", qualifiedByName = "userIdToUser")
    @Mapping(target = "createdBy", source = "createdBy", qualifiedByName = "userIdToUser")
    @Mapping(target = "members", ignore = true)
    @Mapping(target = "projects", ignore = true) 
    TeamModel toEntity(TeamDTO teamDTO);

    @Named("userIdToUser")
    default UsersModel userIdToUser(Long userId) {
        if (userId == null) return null;
        UsersModel user = new UsersModel();
        user.setId(userId);
        return user;
    }

    default List<TeamDTO> toDTOList(List<TeamModel> teams){
        return teams.stream().map(this::toDTO).toList();
    }
}
