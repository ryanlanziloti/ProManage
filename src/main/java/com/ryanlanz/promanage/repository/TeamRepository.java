package com.ryanlanz.promanage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ryanlanz.promanage.model.TeamModel; 

@Repository
public interface TeamRepository extends JpaRepository<TeamModel,Long> {
    

}
