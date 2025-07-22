package com.ryanlanz.promanage.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.ryanlanz.promanage.model.enums.Priority;
import com.ryanlanz.promanage.model.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table; 
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Tasks")
@Getter @Setter @NoArgsConstructor
public class TaskModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsersModel user;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectModel project;

    @Column(name = "task_description")
    private String taskDescription;

    @Column(name = "status")
    private Status status;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "completed_date")
    private LocalDateTime completedDate;

    @Column(name = "priority")
    private Priority priority;
}
