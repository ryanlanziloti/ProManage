package com.ryanlanz.promanage.model.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import com.ryanlanz.promanage.model.enums.Status;

public record ProjectDTO(
    Long id,
    Long teamId,
    String projectName,
    String projectDescription,
    LocalDate createdAt,
    Long createdBy,
    LocalDate updateAt,
    Long updatedBy,
    LocalDate dueDate,
    LocalDateTime completedDate,
    Status status,
    Set<TaskDTO> tasks
) {}
