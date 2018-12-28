import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Pending } from '../pending';
import { Observable } from 'rxjs';
import { Employee } from '../employee';
import { LeaveDetails } from '../leave-details';
import { Router } from '@angular/router';
import { LeaveDetailsService } from '../leave-details.service';
import { MatTableModule } from '@angular/material/table';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@Component({
  selector: 'app-pending',
  templateUrl: './pending.component.html',
  styleUrls: ['./pending.component.css']
})
export class PendingComponent implements OnInit {
  pend : Observable<LeaveDetails[]>;
  empId : number;
  empData : Observable<Employee[]>;
  flagp : number;
  id:number;
  isButtonDisabled:boolean=true;
  leavId : number;
  pendmock : LeaveDetails[]=[];
  showButton:boolean = false;

  public customerData : any;
  constructor(private empGet:EmployeeService, private pendingService : LeaveDetailsService,
              private router : Router) { 
    this.empId = parseInt(localStorage.getItem("empId")); 
    this.empData=empGet.getEmployees();
    this.flagp=parseInt(localStorage.getItem("empId"));
    this.pend=pendingService.pending(this.empId);
    this.id=parseInt(localStorage.getItem("empMgrId"));
    this.pend.subscribe(res => this.pendmock = res);
    // alert(this.flagp);
  } 

  public searchText : string;
  clickRow(x,e) {

    localStorage.setItem("leaveId",e); 
    // alert(x);
    localStorage.setItem("lempId",x);
    // alert(e);
    this.showButton=true;
  //  alert(localStorage.getItem("leaveId"));
  }
  cancel(){
   this.router.navigate(["/Dashboard"]);
 }
 ngOnInit() {
   this.customerData=this.pendingService.pending(this.empId);
 }
 doApproveDeny() { 
   this.router.navigate(["/ApproveDeny"]);
 }
}
