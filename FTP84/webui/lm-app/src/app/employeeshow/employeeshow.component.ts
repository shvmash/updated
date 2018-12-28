import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Observable } from 'rxjs';
import { Employee } from '../employee';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-employeeshow',
  templateUrl: './employeeshow.component.html',
  styleUrls: ['./employeeshow.component.css']
})
export class EmployeeshowComponent implements OnInit {
  empId : number;
  emps:Employee;
  employ : Observable<Employee>;
  constructor(private employService : EmployeeService,private route : ActivatedRoute) {
    this.employ = employService.getEmpDetails(this.route.snapshot.params["empId"]);
    this.employ.subscribe(res=>this.emps =res); 
   }
  ngOnInit() {
  }
}