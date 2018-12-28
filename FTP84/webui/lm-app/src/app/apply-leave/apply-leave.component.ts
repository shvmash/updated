import { Component, OnInit } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { NgForm } from "@angular/forms";
import { Router } from '@angular/router';
import { EmployeeService } from '../employee.service';
import { LeaveDetails } from '../leave-details';
import { LeaveDetailsService } from '../leave-details.service';

@Component({
  selector: 'app-apply-leave',
  templateUrl: './apply-leave.component.html',
  styleUrls: ['./apply-leave.component.css']
})
export class ApplyLeaveComponent implements OnInit {

  constructor(public applyLeaveService:LeaveDetailsService, public router : Router) {
    this.empId=parseInt(localStorage.getItem("empId"));
    // alert(this.empId);
   }
  model=new LeaveDetails();
  message:string;
  msg:String;
  empId : number;
  isValidFormSubmitted = false;
  calculateDays() {
    let date1: string=this.model.startDate.toString();
    let date2: string=this.model.endDate.toString();
    let diffInMs: number = Date.parse(date2) - Date.parse(date1);
    let diffInHours: number = diffInMs / 1000 / 60 / 60/24;
    this.model.leaveNoOfDays=diffInHours + 1;
    
   // alert(diffInHours);
    //console.log(diffInHours);

    //alert("Event Fired");
}

applyLeave(form: NgForm)
{
    this.isValidFormSubmitted=false;
    if(form.invalid){
   //     alert("Invalid");
     return; 
  }  
    console.log ('end date component' + this.model.endDate);
    this.applyLeaveService.applyLeave(this.model,this.empId).subscribe(
        success => {
            this.msg=success;
            console.log(success);
        },
        err => { 
            this.msg=err;
            console.log(err);
        }
    )
    this.isValidFormSubmitted = true;
}
cancel(){
  this.router.navigate(["/"]);
}

  ngOnInit() {
  }

}
