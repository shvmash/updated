import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeshowmanComponent } from './employeeshowman.component';
import { RouterTestingModule } from '@angular/router/testing';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { EmployeeService } from '../employee.service';
import { HttpClient } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { of } from 'rxjs';




const userServiceStub = {
  getEmpDetails(empId) {
    console.log('came inside the stub');
    const usersdetails =  
      {
        "empId": 3,
        "empName": "Shiva",
        "empEmailId": "shiva@gmail.com",
        "empMobileNo": "56233444",
        "empDateJoined": "2018-12-12",
        "empDept": "Java",
        "empLeaveAvail":23,
        "empMgrId":1,
      }
    return of( usersdetails );
  }
};

describe('EmployeeshowmanComponent', () => {
  let component: EmployeeshowmanComponent;
  let fixture: ComponentFixture<EmployeeshowmanComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        RouterTestingModule, FormsModule,HttpModule
      ],
      declarations: [ EmployeeshowmanComponent], 
      providers: [{provide: EmployeeService, 
        useValue: userServiceStub},
        HttpClient,
        HttpClientTestingModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeshowmanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });



  it('should Check Name for Shiva', () => {
    const fixture = TestBed.createComponent(EmployeeshowmanComponent);
    const app = fixture.debugElement.componentInstance;
    // console.log("Employ value" +app.emps.empName);
    expect(app.emock.empName).toEqual("Shiva");
  //  expect(component).toBeTruthy();
  });


  it('should Check EmpId for Shiva', () => {
    const fixture = TestBed.createComponent(EmployeeshowmanComponent);
    const app = fixture.debugElement.componentInstance;
    // console.log("Employ value" +app.emps.empId);
    expect(app.emock.empId).toEqual(3);
  //  expect(component).toBeTruthy();
  });


  it('should Check empEmailId for Shiva', () => {
    const fixture = TestBed.createComponent(EmployeeshowmanComponent);
    const app = fixture.debugElement.componentInstance;
    // console.log("Employ value" +app.emps.empId);
    expect(app.emock.empEmailId).toEqual("shiva@gmail.com");
  //  expect(component).toBeTruthy();
  });


  it('should Check empMobileNo for Shiva', () => {
    const fixture = TestBed.createComponent(EmployeeshowmanComponent);
    const app = fixture.debugElement.componentInstance;
    // console.log("Employ value" +app.emps.empId);
    expect(app.emock.empMobileNo).toEqual("56233444");
  //  expect(component).toBeTruthy();
  });


  it('should Check empDateJoined for Shiva', () => {
    const fixture = TestBed.createComponent(EmployeeshowmanComponent);
    const app = fixture.debugElement.componentInstance;
    // console.log("Employ value" +app.emps.empId);
    expect(app.emock.empDateJoined).toEqual("2018-12-12");
  //  expect(component).toBeTruthy();
  });


  it('should Check empDept for Shiva', () => {
    const fixture = TestBed.createComponent(EmployeeshowmanComponent);
    const app = fixture.debugElement.componentInstance;
    // console.log("Employ value" +app.emps.empId);
    expect(app.emock.empDept).toEqual("Java");
  //  expect(component).toBeTruthy();
  });



  it('should Check empLeaveAvail for Shiva', () => {
    const fixture = TestBed.createComponent(EmployeeshowmanComponent);
    const app = fixture.debugElement.componentInstance;
    // console.log("Employ value" +app.emps.empId);
    expect(app.emock.empLeaveAvail).toEqual(23);
  //  expect(component).toBeTruthy();
  });


  it('should Check empMgrId for Shiva', () => {
    const fixture = TestBed.createComponent(EmployeeshowmanComponent);
    const app = fixture.debugElement.componentInstance;
    // console.log("Employ value" +app.emps.empId);
    expect(app.emock.empMgrId).toEqual(1);
  //  expect(component).toBeTruthy();
  });


  // it('should render one employee record', async(() => {
  
  //   const fixture = TestBed.createComponent(EmployeeshowmanComponent);
  //   fixture.detectChanges();
  //   fixture.whenStable().then(() => {
  //     fixture.detectChanges();
      
  //     const compiled = fixture.debugElement.nativeElement;
  //     expect(compiled.querySelectorAll('.employee tr').length).toBe(1);
  //   });
  // }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});