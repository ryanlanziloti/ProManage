package com.ryanlanz.promanage.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; 
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "employees")
@Getter@Setter@NoArgsConstructor
public class EmployeesModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "cpf",nullable = false,unique = true)
    private String cpf;

    @Column(name = "hire_date",nullable = false)
    private LocalDate hireDate;
    
    @Column(name = "active",columnDefinition = "boolean default true")
    private Boolean active = true;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private UsersModel user;
    
}
