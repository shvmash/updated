import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Observable } from 'rxjs';
import { Employee } from '../employee';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-employeeshowman',
  templateUrl: './employeeshowman.component.html',
  styleUrls: ['./employeeshowman.component.css']
})
export class EmployeeshowmanComponent implements OnInit {
  empMgrId : number;
  employ : Observable<Employee>;
  emock : Employee;
  constructor(private employService : EmployeeService,private route : ActivatedRoute) {
    this.empMgrId = this.route.snapshot.params["empMgrId"];
    // if (this.empMgrId != 0) {
      this.employ = employService.getEmpDetails(this.empMgrId);
      this.employ.subscribe(res=>this.emock =res);
    // }
   }

  ngOnInit() {
  }

}