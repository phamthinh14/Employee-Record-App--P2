package org.revature.AngularSpringBoot.Service;

import org.revature.AngularSpringBoot.Model.Employee;
import org.revature.AngularSpringBoot.Repository.EmployeeRepository;
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
        return employeeRepository.save(employee);
    }

    /**
     * @return
     */
    @Override
    public List<Employee> fetchEmployeeList() {
        return employeeRepository.findAll();
    }

    /**
     * @param employeeId
     * @return
     */
    @Override
    public Employee fetchEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).get();
    }
//
//    /**
//     * @param employeeId
//     * @param employee
//     * @return
//     */
//    @Override
//    public Employee updateEmployee(Long employeeId, Employee employee) {
//        return null;
//    }
//
//    /**
//     * @param employeeId
//     */
//    @Override
//    public void deleteEmployeeById(Long employeeId) {
//
//    }
}
