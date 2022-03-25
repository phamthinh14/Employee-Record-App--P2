import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees!: Employee[];

  constructor() { }

  ngOnInit(): void {
      this.employees = [{
        "id": 1,
        "firstName": "Ron",
        "lastName": "Lem",
        "emailId": "ron@mail.com"
      },
      {
        "id": 2,
        "firstName": "Jon",
        "lastName": "Kem",
        "emailId": "jon@mail.com"
      }];


  }

}
