package com.ryanlanz.promanage.model.DTO;

import java.util.Set;

public record TeamDTO(
    Long id,
    String teamName,
    Long managedBy, //User Id
    Long createdBy, //User Id
    Set<TeamUsersDTO> members //User Id
) {}
