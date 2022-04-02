package org.revature.AngularSpringBoot.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.revature.AngularSpringBoot.Model.Employee;
import org.revature.AngularSpringBoot.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest
public class ControllerTests {

    private MockMvc mockMvc;
    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();
    @Mock
    private EmployeeRepository employeeRepository;
    @InjectMocks
    private EmployeeController employeeController;

    Employee employee1 = new Employee("Thinh", "Pham", "thinhpham@gmail.com");
    Employee employee2 = new Employee("Los", "Algones", "nearBorder@gmail.com");
    Employee employee3 = new Employee("cun", "Can", "theBeach@gmail.com");

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    public void testGetAll() {
        List<Employee> employeeList = new ArrayList<>(Arrays.asList(employee1, employee2, employee3));
        Mockito.when(employeeRepository.findAll()).thenReturn(employeeList);
        try {
            mockMvc.perform(MockMvcRequestBuilders
                            .get("/api/v1/employees")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDetail() {
        List<Employee> employeeList = new ArrayList<>(Arrays.asList(employee1, employee2, employee3));
        Mockito.when(employeeRepository.findAll()).thenReturn(employeeList);
        try {
            mockMvc.perform(MockMvcRequestBuilders
                            .get("/api/v1/employees")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName", is("Thinh")))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[1].lastName", is("Algones")))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[2].emailId", is("theBeach@gmail.com")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestCreate() {
//        Employee employee = Employee.builder
    }
}
