package com.ryanlanz.promanage.model;

import java.time.LocalDate;

import com.ryanlanz.promanage.model.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Projects")
@Getter @Setter @AllArgsConstructor
public class ProjectModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamModel team;

    @Column(name = "project_name",nullable = false)
    private String projectName;

    @Column(name = "project_description",nullable = false)
    private String projectDescription;

    @Column(name = "created_at",nullable = false)
    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "created_by",nullable = false)
    private UsersModel user;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @ManyToOne
    @JoinColumn(name = "updated_by")
    private UsersModel userUpdated;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "completed_date",nullable = true)
    private LocalDate completedDate;

    @Column(name = "status")
    private Status status;
}
