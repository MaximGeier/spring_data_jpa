package com.maximgeier.spring.springboot.spring_data_jpa.service;

import com.maximgeier.spring.springboot.spring_data_jpa.dao.EmployeeRepository;
import com.maximgeier.spring.springboot.spring_data_jpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {

        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Employee employee = null;
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isPresent()) {
            employee = employeeOptional.get();
        }
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAllByName(String name) {
        return employeeRepository.findAllByName(name);
    }

    @Override
    public List<Employee> findEmployeeBySalaryBetween(int minSalary, int maxSalary) {
        return employeeRepository.findEmployeeBySalaryBetween(minSalary, maxSalary);
    }
}