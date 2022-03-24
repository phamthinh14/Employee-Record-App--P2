package org.revature.AngularSpringBoot.Repository;

import org.revature.AngularSpringBoot.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository is a specialization of @Component, which is used to indicate that the class provides
//a mechanism for storage, retrieval, update, delete, and search operations on objects.
@Repository
//JpaRepository interface gives us access to methods such as find/save/delete by id, etc.
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
}
