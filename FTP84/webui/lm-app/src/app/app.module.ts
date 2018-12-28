import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
//import { UserService } from './user.service';
//import { UserComponent } from './user/user.component';
import { EmployeeComponent } from './employee/employee.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeshowComponent } from './employeeshow/employeeshow.component';
import { EmployeeshowmanComponent } from './employeeshowman/employeeshowman.component';
import { ApplyLeaveComponent } from './apply-leave/apply-leave.component';
import { FormsModule } from '@angular/forms';
import { PendingComponent } from './pending/pending.component';
import { ApproveDenyComponent } from './approve-deny/approve-deny.component';
import { LoginComponent } from './login/login.component';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { MatTableModule } from '@angular/material/table';
// import { HttpClientModule } from '@angular/common/http';
import { HttpModule } from '@angular/http';
import { EmployeeService } from './employee.service';
import { LeavehisComponent } from './leavehis/leavehis.component';
import { NgForm } from "@angular/forms";

import { GrdFilterPipe } from './grd-filter.pipe';

const appRoutes : Routes = [
  {path : '', component : EmployeeComponent},
  { path : 'Login/:empId', component : LoginComponent},
  // {path : 'Dashboard', component : DashboardComponent},
  {path : 'Dashboard/:empId/:empMgrId', component : DashboardComponent},
{path : 'Employeeshow/:empId', component : EmployeeshowComponent},
 {path : 'Employeeshowman', component : EmployeeshowmanComponent},
 {path : 'ApproveDeny', component : ApproveDenyComponent},
 {path : 'ApplyLeave', component : ApplyLeaveComponent}
  // {path : '', component : AppComponent}
];


@NgModule({
  declarations: [
    AppComponent,
    //UserComponent,
    EmployeeComponent,
    DashboardComponent,
    EmployeeshowComponent,
    EmployeeshowmanComponent,
    ApplyLeaveComponent,
    PendingComponent,
    ApproveDenyComponent,
    LoginComponent,
    LeavehisComponent,GrdFilterPipe
  ],
  imports: [
    BrowserModule,
    HttpModule,FormsModule,MatTableModule,
    // HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [EmployeeService],
  bootstrap: [AppComponent], exports: [
    MatTableModule
  ]
})
export class AppModule { }