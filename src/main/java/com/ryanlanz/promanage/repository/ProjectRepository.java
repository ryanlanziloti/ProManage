package com.ryanlanz.promanage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ryanlanz.promanage.model.ProjectModel;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectModel,Long>{
    
}
