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

    public EmployeesDTO getById(Long id){
        return mapper.toDTO(repository.findById(id).orElseThrow());
    }

    //POST
    public EmployeesDTO create(EmployeesDTO employeeDTO){
        EmployeesModel employee = mapper.toEntity(employeeDTO); 
        return mapper.toDTO(repository.save(employee));
    }

    //PUT
    public EmployeesDTO update(EmployeesDTO employeesDTO){
        EmployeesModel employeesModel = mapper.toEntity(employeesDTO);
        repository.findById(employeesModel.getId())
            .orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeesModel.getId()));
        return mapper.toDTO(repository.save(employeesModel));
    }

    //DELETE
    public boolean deleteEmployee(Long id){
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
