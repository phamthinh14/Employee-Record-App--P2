package org.revature.AngularSpringBoot.service;

import org.revature.AngularSpringBoot.Exception.ResourceNotFoundException;
import org.revature.AngularSpringBoot.Model.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee saveEmployee(Employee employee);

    public List<Employee> fetchEmployeeList();

    public Employee fetchEmployeeById(Long employeeId) throws ResourceNotFoundException;

    public Employee updateEmployee(Long employeeId, Employee employee);

    public void deleteEmployeeById(Long employeeId);

}
