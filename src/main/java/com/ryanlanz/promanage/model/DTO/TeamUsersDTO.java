package com.ryanlanz.promanage.model.DTO;

import com.ryanlanz.promanage.model.enums.TeamRoles;

public record TeamUsersDTO(
    Long userId, //User.id
    String username, //user.name
    Long teamId, //team.id
    String teamName, //team.name
    TeamRoles role
) {}
