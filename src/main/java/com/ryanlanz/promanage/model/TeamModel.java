package com.ryanlanz.promanage.model;

import java.util.HashSet;
import java.util.Set;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany; 
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "team")
@Getter @Setter @AllArgsConstructor
public class TeamModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    @Column(name = "team_name",nullable = false)
    private String teamName;

    @ManyToOne
    @JoinColumn(name = "managed_by",nullable = true, unique = false)
    private UsersModel managedBy;

    @ManyToOne
    @JoinColumn(name = "created_by",nullable = false, unique = false)
    private UsersModel createdBy;

    @OneToMany(mappedBy = "team")
    private Set<TeamUsersModel> members = new HashSet<>();
 
    @OneToMany(mappedBy = "team")
    private Set<ProjectModel> projects = new HashSet<>(); 

}
