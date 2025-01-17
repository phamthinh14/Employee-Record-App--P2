package org.revature.AngularSpringBoot.service;

import org.revature.AngularSpringBoot.Exception.ResourceNotFoundException;
import org.revature.AngularSpringBoot.Model.Employee;
import org.revature.AngularSpringBoot.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * @param employee
     * @return
     */
    @Override
    public Employee saveEmployee(Employee employee) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public List<Employee> fetchEmployeeList() {
        return null;
    }

    /**
     * @param employeeId
     * @return
     * @throws ResourceNotFoundException
     */
    @Override
    public Employee fetchEmployeeById(Long employeeId) throws ResourceNotFoundException {
        return null;
    }

    /**
     * @param employeeId
     * @param employee
     * @return
     */
    @Override
    public Employee updateEmployee(Long employeeId, Employee employee) {
        return null;
    }

    /**
     * @param employeeId
     */
    @Override
    public void deleteEmployeeById(Long employeeId) {

    }
}
