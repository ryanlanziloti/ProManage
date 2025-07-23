package com.ryanlanz.promanage.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.ryanlanz.promanage.model.TeamUsersModel;
import com.ryanlanz.promanage.model.DTO.TeamUsersDTO;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TeamUsersMapper {
    
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "username", source = "user.username")
    @Mapping(target = "teamId", source = "team.id")
    @Mapping(target = "teamName", source = "team.teamName")
    TeamUsersDTO toDTO(TeamUsersModel teamUsersModel);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "team", ignore = true)
    @Mapping(target = "teamModel", ignore = true)
    TeamUsersModel toEntity(TeamUsersDTO teamUsersDTO);

    default List<TeamUsersDTO> toTeamUsersDTOList(List<TeamUsersModel> teams){
        return teams.stream().map(this::toDTO).toList();
    }
}
