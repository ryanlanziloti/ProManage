package com.ryanlanz.promanage.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.ryanlanz.promanage.model.enums.Roles;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table; 
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor
public class UsersModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "employee_id",nullable = false, unique = true)
    private EmployeesModel employee;

    @Column(name = "created_at",nullable = false)
    private LocalDate createdAt;

    @Column(name = "created_by",nullable = true)
    private Long createdBy;

    @Column(name = "username",nullable = false)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private Roles role;

    @Column(name = "active",columnDefinition = "boolean default true")
    private Boolean active = true;

    @OneToMany(mappedBy = "user")
    private Set<TeamUsersModel> teamMemberships = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<ProjectModel> createdProjects = new HashSet<>(); 
    
    @OneToMany(mappedBy = "user")
    private Set<TaskModel> tasks = new HashSet<>(); 
 
}
