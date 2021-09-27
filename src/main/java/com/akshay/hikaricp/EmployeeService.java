package com.akshay.hikaricp;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDTO> getEmployees() {
        List<EmployeeEntity> employees = employeeRepository.findAll();
        return employees.stream().map(e ->
                new EmployeeDTO(e.getId(), e.getName())).collect(Collectors.toList());
    }
}
