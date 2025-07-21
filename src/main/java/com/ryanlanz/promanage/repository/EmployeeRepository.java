package com.ryanlanz.promanage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ryanlanz.promanage.model.EmployeesModel;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeesModel, Long> {


}
