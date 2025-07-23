package com.ryanlanz.promanage.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ryanlanz.promanage.model.UsersModel;

@Repository
public interface UserRepository extends JpaRepository<UsersModel,Long>{
    
    @EntityGraph(attributePaths = {"tasks", "employee"})
    @Query("SELECT u FROM UsersModel u WHERE u.id = :userId")
    Optional<UsersModel> findUserWithTasks(@Param("userId") Long userId);

}
