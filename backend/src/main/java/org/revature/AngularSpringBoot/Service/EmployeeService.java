package org.revature.AngularSpringBoot.Service;

import org.revature.AngularSpringBoot.Model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public Employee saveEmployee(Employee employee);

    public List<Employee> fetchEmployeeList();

    public Employee fetchEmployeeById(Long id);


//
//    public List<Employee> fetchEmployeeList();
//
//    public Employee fetchEmployeeById(Long employeeId) throws ResourceNotFoundException;
//
//    public Employee updateEmployee(Long employeeId, Employee employee);
//
//    public void deleteEmployeeById(Long employeeId);

}
