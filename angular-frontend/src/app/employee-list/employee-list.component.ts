import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee'

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
      "firstName": "Ronald",
      "lastName": "Lemus",
      "emailId": "ronald.cristobal.lemus@outlook.com"
    },
    {
      "id": 2,
      "firstName": "John",
      "lastName": "Doe",
      "emailId": "John@mail.com"
    }];
  }

}
