package com.ryanlanz.promanage.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.ryanlanz.promanage.model.ProjectModel;
import com.ryanlanz.promanage.model.TeamModel;
import com.ryanlanz.promanage.model.UsersModel;
import com.ryanlanz.promanage.model.DTO.ProjectDTO;

@Mapper(componentModel = "spring", 
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProjectMapper extends TaskMapper{
     
    @Mapping(target = "teamId",source = "team.id")
    @Mapping(target = "createdBy",source = "user.id")
    @Mapping(target = "updatedBy",source = "userUpdated.id")
    @Mapping(target = "tasks",source = "tasks")
    ProjectDTO toDTOProjectDTO(ProjectModel projectModel);

    @Mapping(target = "tasks",ignore = true)
    @Mapping(target = "user", source = "createdBy", qualifiedByName = "userIdToUser")
    @Mapping(target = "userUpdated", source = "updatedBy", qualifiedByName = "userIdToUser")
    @Mapping(target = "team", source = "teamId", qualifiedByName = "teamIdToTeam")
    ProjectModel toEntityProjectModel(ProjectDTO projectDTO);

    @Named("userIdToUser")
    default UsersModel userIdToUser(Long userId) {
        if (userId == null) return null;
        UsersModel user = new UsersModel();
        user.setId(userId);
        return user;
    }

    @Named("teamIdToTeam")
    default TeamModel teamIdToTeam(Long teamId) {
        if (teamId == null) return null;
        TeamModel team = new TeamModel();
        team.setId(teamId);
        return team;
    }

    default List<ProjectDTO> toDTOProjectList(List<ProjectModel> projects){
        return projects.stream().map(this::toDTOProjectDTO).toList();
    }
}
