import { Component, OnInit } from '@angular/core';
import { Login } from '../login';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { EmployeeService } from '../employee.service';
import { Employee } from 'src/app/employee';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  empId: number;
  empMgrId: number;

  model=new Login();
  
    constructor(private route:ActivatedRoute,private router:Router) { 
      this.model.userName=this.route.snapshot.params["empId"];
    }
    Login(empId){
      this.empId=parseInt(this.route.snapshot.params["empId"]);
      this.empMgrId=parseInt(localStorage.getItem("mgrId"));
      // alert(this.empId+"  "+this.empMgrId);
      if(this.model.passWord=="s"){
        this.router.navigate(['/Dashboard',this.empId,this.empMgrId]);
      }
      else{
        alert("Oops....!!!Invalid Credential");
      }
  }

  ngOnInit() {
  }

}
