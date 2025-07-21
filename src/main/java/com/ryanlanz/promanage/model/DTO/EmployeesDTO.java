package com.ryanlanz.promanage.model.DTO;

import java.time.LocalDate;


public record EmployeesDTO(
    Long id,
    String name,
    String cpf,
    LocalDate hireDate,
    Boolean active,
    Long userId  // ID do usuário associado (opcional)
) {
    // Método estático alternativo (se não quiser usar MapStruct)
    /*public static EmployeesDTO fromEntity(EmployeesModel entity) {
        return new EmployeesDTO(
            entity.getId(),
            entity.getName(),
            entity.getCpf(),
            entity.getHireDate(),
            entity.getActive(),
            entity.getUser() != null ? entity.getUser().getId() : null
        );
    }*/
}
