package com.ryanlanz.promanage.model.DTO;

import java.time.LocalDate;
import java.util.Set;

import com.ryanlanz.promanage.model.enums.Roles;

public record UserDTO(
    Long id,
    Long employeeId,//employee
    LocalDate createdAt,
    Long createdBy,
    String username,
    Roles role,
    boolean active,
    //Long projectId,
    Set<TaskDTO> tasks
) {}
