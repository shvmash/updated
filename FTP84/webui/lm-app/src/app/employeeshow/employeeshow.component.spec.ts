import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeshowComponent } from './employeeshow.component';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { AppComponent } from '../app.component';
import { EmployeeComponent } from '../employee/employee.component';
import { EmployeeService } from '../employee.service';
import { HttpClient } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { of, Observable } from 'rxjs';
import { Employee } from '../employee';



const userServiceStub = {
  getEmpDetails(empId) {
    console.log('came inside the stub');
    const usersdetails =  
      {
        "empId": 1,
        "empName": "Anshuman",
        "empEmailId": "mishraanshuman1705@gmail.com",
        "empMobileNo": "56233444",
        "empDateJoined": "2018-12-12",
        "empDept": "DOTNET",
        "empLeaveAvail":12,
        "empMgrId":0,
      }
    return of( usersdetails );
  }
};




describe('EmployeeshowComponent', () => {
  let component: EmployeeshowComponent;
  let fixture: ComponentFixture<EmployeeshowComponent>;

 
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        RouterTestingModule, FormsModule,HttpModule
      ],
      declarations: [ EmployeeshowComponent ], 
      providers: [{provide: EmployeeService, 
        useValue: userServiceStub},
        HttpClient,
        HttpClientTestingModule]
    })
    .compileComponents();
  }));


  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeshowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });


  it('should Check Name for Anshuman', () => {
    const fixture = TestBed.createComponent(EmployeeshowComponent);
    const app = fixture.debugElement.componentInstance;
    // console.log("Employ value" +app.emps.empName);
    expect(app.emps.empName).toEqual("Anshuman");
  //  expect(component).toBeTruthy();
  });


  it('should Check EmpId for Anshuman', () => {
    const fixture = TestBed.createComponent(EmployeeshowComponent);
    const app = fixture.debugElement.componentInstance;
    // console.log("Employ value" +app.emps.empId);
    expect(app.emps.empId).toEqual(1);
  //  expect(component).toBeTruthy();
  });


  it('should Check empEmailId for Anshuman', () => {
    const fixture = TestBed.createComponent(EmployeeshowComponent);
    const app = fixture.debugElement.componentInstance;
    // console.log("Employ value" +app.emps.empId);
    expect(app.emps.empEmailId).toEqual("mishraanshuman1705@gmail.com");
  //  expect(component).toBeTruthy();
  });


  it('should Check empMobileNo for Anshuman', () => {
    const fixture = TestBed.createComponent(EmployeeshowComponent);
    const app = fixture.debugElement.componentInstance;
    // console.log("Employ value" +app.emps.empId);
    expect(app.emps.empMobileNo).toEqual("56233444");
  //  expect(component).toBeTruthy();
  });


  it('should Check empDateJoined for Anshuman', () => {
    const fixture = TestBed.createComponent(EmployeeshowComponent);
    const app = fixture.debugElement.componentInstance;
    // console.log("Employ value" +app.emps.empId);
    expect(app.emps.empDateJoined).toEqual("2018-12-12");
  //  expect(component).toBeTruthy();
  });


  it('should Check empDept for Anshuman', () => {
    const fixture = TestBed.createComponent(EmployeeshowComponent);
    const app = fixture.debugElement.componentInstance;
    // console.log("Employ value" +app.emps.empId);
    expect(app.emps.empDept).toEqual("DOTNET");
  //  expect(component).toBeTruthy();
  });



  it('should Check empLeaveAvail for Anshuman', () => {
    const fixture = TestBed.createComponent(EmployeeshowComponent);
    const app = fixture.debugElement.componentInstance;
    // console.log("Employ value" +app.emps.empId);
    expect(app.emps.empLeaveAvail).toEqual(12);
  //  expect(component).toBeTruthy();
  });


  it('should Check empMgrId for Anshuman', () => {
    const fixture = TestBed.createComponent(EmployeeshowComponent);
    const app = fixture.debugElement.componentInstance;
    // console.log("Employ value" +app.emps.empId);
    expect(app.emps.empMgrId).toEqual(0);
  //  expect(component).toBeTruthy();
  });


  it('should render one employee record', async(() => {
  
    const fixture = TestBed.createComponent(EmployeeshowComponent);
    fixture.detectChanges();
    fixture.whenStable().then(() => {
      fixture.detectChanges();
      
      const compiled = fixture.debugElement.nativeElement;
      expect(compiled.querySelectorAll('.button tr').length).toBe(1);
    });
  }));



  it('should create', () => {
    expect(component).toBeTruthy();
  });
  
});

