import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {
  
  id!: number;
  employee: Employee = new Employee();

  //We inject ActivatedRoute into the constructor which provides access to information about a 
  //route associated with a component that is loaded in an outlet.
  
  constructor(private employeeService: EmployeeService, 
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
  //Using snapshot(gives current snapshot of route) and params(gives an observable of the matrix parameters scoped to this route) 
  //properties to to provide getEmployeeById the required id.
    this.id = this.route.snapshot.params['id'];


    this.employeeService.getEmployeeById(this.id).subscribe(data => {
      this.employee = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.employeeService.updateEmployee(this.id, this.employee).subscribe( data =>{
      console.log(data);
      this.goToEmployeeList();
    });
  }

  goToEmployeeList() {
    this.router.navigate(['/employees']);
  }

}
