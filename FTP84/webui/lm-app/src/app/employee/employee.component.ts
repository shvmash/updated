import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';
import { MatTableModule } from '@angular/material/table';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  employee : Observable<Employee[]>;
  emps:Employee[] = [];
  constructor(private employeeService : EmployeeService,private router : Router) {
    this.employee = employeeService.getEmployees();
    this.employeeService.getEmployees().subscribe(countries => this.emps = countries);
    console.log("Demo Data")
    console.log(this.emps);
    
   }
   public searchText : string;
 
    empId : number;
    empName : string;
    empMgrId : number;
   details(empId,empMgrId) {
     this.empId = empId;
     this.empMgrId = empMgrId;
     localStorage.setItem("empId",empId);
     localStorage.setItem("mgrId",empMgrId);
    //  alert(this.empMgrId);
     this.router.navigate(['/Login',this.empId]);
   }
 
  ngOnInit() {
  }
}
