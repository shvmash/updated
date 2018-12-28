import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { of, Observable } from 'rxjs';
import { RouterTestingModule } from '@angular/router/testing';
import { EmployeeComponent } from './employee.component';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';
import { FormsModule } from '@angular/forms';

import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { HttpClient } from '@angular/common/http';
import { HttpModule } from '@angular/http';
import { GrdFilterPipe } from '../grd-filter.pipe';


const userServiceStub = {
  getEmployees() {
    console.log('came inside the stub');
    const employee =  [
      {
        "empId": 1,
        "empName": "Anshuman",
        "empEmailId": "mishraanshuman1705@gmail.com",
        "empMobileNo": "56233444",
        "empDateJoined": "2018-12-12",
        "empDept": "DOTNET",
        "empLeaveAvail":12,
        "empMgrId":0,
      },
      {
        "empId": 2,
        "empName": "Sravanthi",
        "empEmailId": "Sravanthi@gmail.com",
        "empMobileNo": "56233444",
        "empDateJoined": "2018-12-12",
        "empDept": "DOTNET",
        "empLeaveAvail":12,
        "empMgrId":1,
      },
      {
        "empId": 3,
        "empName": "Rashmi",
        "empEmailId": "rashmi@gmail.com",
        "empMobileNo": "56233444",
        "empDateJoined": "2018-12-12",
        "empDept": "DOTNET",
        "empLeaveAvail":12,
        "empMgrId":1,
      },
      {
        "empId": 4,
        "empName": "Shiva",
        "empEmailId": "Shiva@gmail.com",
        "empMobileNo": "56233444",
        "empDateJoined": "2018-12-12",
        "empDept": "DOTNET",
        "empLeaveAvail":12,
        "empMgrId":2,
      },
      {
        "empId": 5,
        "empName": "Prasanna",
        "empEmailId": "prassucp@gmail.com",
        "empMobileNo": "56233444",
        "empDateJoined": "2018-12-12",
        "empDept": "DOTNET",
        "empLeaveAvail":12,
        "empMgrId":0,
      }
    ];
    return of( employee );
  }
};

describe('EmployeeComponent', () => {
  let component: EmployeeComponent;
  let service : EmployeeService;
  let emps : Observable<Employee>;
  let fixture: ComponentFixture<EmployeeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        RouterTestingModule, FormsModule,HttpModule
      ],
      declarations: [ EmployeeComponent, GrdFilterPipe  ],
      schemas : [
        CUSTOM_ELEMENTS_SCHEMA
      ],
      providers: [{provide: EmployeeService, 
        useValue: userServiceStub},
        HttpClient,
        HttpClientTestingModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create Anshuman', () => {
    const fixture = TestBed.createComponent(EmployeeComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps[0].empName).toEqual('Anshuman');
  //  expect(component).toBeTruthy();
  });



  it('should Check for emailId', () => {
    const fixture = TestBed.createComponent(EmployeeComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps[0].empEmailId).toEqual('mishraanshuman1705@gmail.com');
  //  expect(component).toBeTruthy();
  });


  it('should Check for empMobileNo', () => {
    const fixture = TestBed.createComponent(EmployeeComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps[0].empMobileNo).toEqual('56233444');
  //  expect(component).toBeTruthy();
  });



  it('should Check for empDept', () => {
    const fixture = TestBed.createComponent(EmployeeComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps[0].empDept).toEqual('DOTNET');
  //  expect(component).toBeTruthy();
  });


  it('should Check for empMgrId', () => {
    const fixture = TestBed.createComponent(EmployeeComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps[0].empMgrId).toEqual(0);
  //  expect(component).toBeTruthy();
  });


  it('should Check for empId', () => {
    const fixture = TestBed.createComponent(EmployeeComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps[0].empId).toEqual(1);
  //  expect(component).toBeTruthy();
  });


  it('should Check for empLeaveAvail', () => {
    const fixture = TestBed.createComponent(EmployeeComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps[0].empLeaveAvail).toEqual(12);
  //  expect(component).toBeTruthy();
  });


  it('should Check for empDateJoined', () => {
    const fixture = TestBed.createComponent(EmployeeComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps[4].empDateJoined).toEqual("2018-12-12");
  //  expect(component).toBeTruthy();
  });


  it('should create', () => {
    expect(component).toBeTruthy();
  }); 

  it('should render one employee record', async(() => {
    
      const fixture = TestBed.createComponent(EmployeeComponent);
      fixture.detectChanges();
      fixture.whenStable().then(() => {
        fixture.detectChanges();
        
        const compiled = fixture.debugElement.nativeElement;
        expect(compiled.querySelectorAll('.employee tr').length).toBe(5);
      });
    }));
});