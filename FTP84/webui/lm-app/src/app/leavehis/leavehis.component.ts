import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';
import { LeaveDetails } from '../leave-details';
import { LeaveDetailsService } from '../leave-details.service';

@Component({
  selector: 'app-leavehis',
  templateUrl: './leavehis.component.html',
  styleUrls: ['./leavehis.component.css']
})
export class LeavehisComponent implements OnInit {
  employ : Observable<LeaveDetails[]>;
  hismock : LeaveDetails[]=[];
  constructor(private hist : LeaveDetailsService,private route : Router) { 
   
    this.employ = hist.getLeaveHis(localStorage.getItem("empId"));
    this.employ.subscribe(countries => this.hismock = countries);
   }

  ngOnInit() {
  }

}