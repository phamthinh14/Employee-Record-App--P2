package org.revature.AngularSpringBoot.Controller;

import java.util.List;

import org.revature.AngularSpringBoot.Exception.ResourceNotFoundException;
import org.revature.AngularSpringBoot.Model.Employee;
import org.revature.AngularSpringBoot.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

//@RestController is a convenience annotation that is itself annotated with @Controller and @ResponseBody. Applied to a
//class to mark it as a request handler. Used to created RESTful web services using Spring MVC.
@RestController

@CrossOrigin(origins = "http://localhost:4200")

//@RequestMapping is the most common and widely used annotation in Spring MVC. Used to map web requests onto specific handler classes and/or handler methods. 
//Can be applied to the controller class as well as methods. 
@RequestMapping("/api/v1/")
public class EmployeeController {
    //@Autowired is used for dependency injections. In Spring Boot all loaded beans are eligible for auto wiring to another bean. 
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private JavaMailSender javaMailSender;

    //@GetMapping is used for mapping HTTP GET requests onto specific handler methods. Specifically acts as a shortcut for @RequestMapping(method = RequestMethod.GET)
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    //@PostMapping maps HTTP POST requests onto specific handler methods. Specifically acts as a shortcut for @RequestMapping(method=RequestMethod.POST)
    @PostMapping("/employees")
    public Employee postArtist(@RequestBody Employee employee) {
        SimpleMailMessage message = new SimpleMailMessage();
        String content = "Congratulation! Your registration is successful.\n" +
                "Your first name is: " + employee.getFirstName() + "\n" +
                "Your last name is: " + employee.getLastName() + "\n" +
                "We will contact you by " + employee.getEmailId() + "\n\n" +
                "Best Regards,\nRevature.";
        message.setFrom("revature.donotreply@gmail.com");
        message.setTo(employee.getEmailId());
        message.setSubject("Successful Registration");
        message.setText(content);
        javaMailSender.send(message);
        return employeeRepository.save(employee);
    }


    //Method to delete employee by the Id. Path Variable {id} is passed as the parameter of the method. 
    @GetMapping("/employees/{id}")
    //Using ResponseEntity class with Employee passed as a generic because we need to return an Http response.
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        //Employee object is made using employeeRepo class and it's findById method. Since FindById returns Optional <Employee> we use 
        //orElseThrow() method to throw an exception if the record isn't found in the database. orElseThrow() uses functional interfaces so we must pass
        // a lambda function as the parameter to it with which we use a ResourceNotFoundException to display an error message when the exception is thrown.
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with id : " + id));

        return ResponseEntity.ok(employee);

    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee newEmployeeInfo) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with id : " + id));
        employee.setFirstName(newEmployeeInfo.getFirstName());
        employee.setLastName(newEmployeeInfo.getLastName());
        employee.setEmailId(newEmployeeInfo.getEmailId());
        Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }
}
