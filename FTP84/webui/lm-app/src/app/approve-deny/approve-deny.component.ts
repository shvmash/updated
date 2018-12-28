import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../employee';
import { LeaveDetails } from '../leave-details';
import { Router } from '@angular/router';
import { EmployeeService } from '../employee.service';
import { parse } from 'querystring';
import { LeaveDetailsService } from '../leave-details.service';

@Component({
  selector: 'app-approve-deny',
  templateUrl: './approve-deny.component.html',
  styleUrls: ['./approve-deny.component.css']
})
export class ApproveDenyComponent implements OnInit {
  empData : Observable<Employee>;
  leaveData : Observable<LeaveDetails>;
  empId : number;
  leaveId:number;
  mgrId : number;
  msg : String;
  constructor(public empDetails:EmployeeService, public applyLeaveService: LeaveDetailsService, public router : Router) {
    this.empId=parseInt(localStorage.getItem("lempId"));
    this.empData=empDetails.getEmpDetails(this.empId);
    this.leaveId=parseInt(localStorage.getItem("leaveId"));
    this.leaveData=applyLeaveService.getLeaveDetails(this.leaveId);
  }
  ld = new LeaveDetails(); 
  ed = new Employee();
  approve() {
   // this.ld.leaveId=parseInt(localStorage.getItem("leaveId")); 
    this.ld.leaveStatus="APPROVED";
    this.ld.empId=parseInt(localStorage.getItem("empId"));
//    alert(this.ld.mgrComments + " " +this.ld.leaveStatus + " " +this.ld.empId); 
    this.applyLeaveService.approve(this.ld,this.leaveId).subscribe(
        success => {
            this.msg=success;
        },
        err => { 
            this.msg=err;
            console.log(err);
        }
    )
  }
  reject() {
    this.ld.leaveId=parseInt(localStorage.getItem("leaveId")); 
    this.ld.leaveStatus="DENIED"; 
    this.mgrId=parseInt(localStorage.getItem("empId"));
    this.ld.empId=parseInt(localStorage.getItem("empId"));
   // alert(this.ld.leaveManagerComm + " " +this.ld.leaveId + " " +this.mgrId); 
    this.applyLeaveService.approve(this.ld,this.leaveId).subscribe(
        success => {
            this.msg=success;
        },
        err => { 
            this.msg=err;
            console.log(err);
        }
    )
  }

  cancel(){
    this.router.navigate(["/"]);
  }

  ngOnInit() {
  }

}