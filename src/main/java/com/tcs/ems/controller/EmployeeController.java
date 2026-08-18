package com.tcs.ems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.ems.entity.Employee;
import com.tcs.ems.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // CREATE EMPLOYEE
    @PostMapping
    public String createEmployee(
          @Valid  @RequestBody Employee employee) {
            return "data inserted";
        //return employeeService.createEmployee(employee);
    }

    // GET EMPLOYEE BY ID
    @GetMapping("/{id}")
    public Optional<Employee> fetchEmployeeById(
            @PathVariable Long id) {

        return employeeService.fetchEmployeeById(id);
    }

    // GET ALL EMPLOYEES
    @GetMapping
    public List<Employee> fetchAllEmployee() {

        return employeeService.fetchAllEmployee();
    }

    // DELETE EMPLOYEE
    @DeleteMapping("/{id}")
    public String deleteEmployeeById(
            @PathVariable Long id) {

        return employeeService.deleteEmployeeById(id);
    }

    // UPDATE EMPLOYEE
    @PutMapping("/{id}")
    public String updateEmployeeById(
            @PathVariable Long id,
            @RequestBody Employee employee) {

        return employeeService.updateEmployeeById(id, employee);
    }
}