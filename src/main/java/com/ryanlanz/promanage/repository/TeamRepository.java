package com.ryanlanz.promanage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ryanlanz.promanage.model.TeamModel; 

@Repository
public interface TeamRepository extends JpaRepository<TeamModel,Long> {
    

}
