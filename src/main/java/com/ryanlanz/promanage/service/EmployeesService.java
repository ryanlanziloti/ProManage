package com.ryanlanz.promanage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryanlanz.promanage.model.EmployeesModel;
import com.ryanlanz.promanage.model.DTO.EmployeesDTO;
import com.ryanlanz.promanage.model.mapper.EmployeesMapper;
import com.ryanlanz.promanage.repository.EmployeeRepository;

@Service
public class EmployeesService {
    
    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private EmployeesMapper mapper;

    //GET
    public List<EmployeesDTO> getAll(){
        List<EmployeesModel> employees = repository.findAll();
        return mapper.toDTOList(employees);
    }

    //POST
    public EmployeesDTO create(EmployeesDTO employeeDTO){
        EmployeesModel employee = mapper.toEntity(employeeDTO); 
        return mapper.toDTO(repository.save(employee));
    }
}
