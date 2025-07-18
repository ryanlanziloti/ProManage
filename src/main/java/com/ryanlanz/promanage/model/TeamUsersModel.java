package com.ryanlanz.promanage.model;
 

import com.ryanlanz.promanage.model.enums.TeamRoles;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType; 
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn; 
import jakarta.persistence.ManyToOne; 
import jakarta.persistence.Table;

@Entity
@Table(name = "team_users")
public class TeamUsersModel {
    
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private UsersModel user;

    @Id 
    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    private TeamModel team;

    @Column(name = "role")
    private TeamRoles role;

    @ManyToOne(fetch = FetchType.LAZY)
    private TeamModel TeamModel;
}
