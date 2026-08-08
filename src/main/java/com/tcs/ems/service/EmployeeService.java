package com.tcs.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tcs.ems.entity.Employee;
import com.tcs.ems.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // CREATE
    public String createEmployee(Employee employee) {

        employeeRepository.save(employee);

        return "Employee data inserted";
    }

    // GET BY ID
    public Optional<Employee> fetchEmployeeById(Long id) {

        return employeeRepository.findById(id);
    }

    // GET ALL
    public List<Employee> fetchAllEmployee() {

        return employeeRepository.findAll();
    }

    // DELETE
    public String deleteEmployeeById(Long id) {

        Optional<Employee> employee =
                employeeRepository.findById(id);

        if (employee.isPresent()) {

            employeeRepository.deleteById(id);

            return "Employee data deleted";
        }

        return "Employee not found";
    }

    // UPDATE
    public String updateEmployeeById(Long id, Employee employee) {

        Optional<Employee> existingEmployee =
                employeeRepository.findById(id);

        if (existingEmployee.isPresent()) {

            Employee existing = existingEmployee.get();

            existing.setName(employee.getName());
            existing.setEmail(employee.getEmail());
            existing.setDepartment(employee.getDepartment());
            existing.setSalary(employee.getSalary());

            employeeRepository.save(existing);

            return "Employee data updated";
        }

        return "Employee not found";
    }
}