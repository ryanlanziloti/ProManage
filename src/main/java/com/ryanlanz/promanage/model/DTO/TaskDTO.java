package com.ryanlanz.promanage.model.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.ryanlanz.promanage.model.enums.Status;
import com.ryanlanz.promanage.model.enums.Priority;

public record TaskDTO(
    Long id,
    Long userId,
    Long projectId,
    String taskDescription,
    Status status,
    LocalDate dueDate,
    LocalDateTime completedDate,
    Priority priority
) {
}