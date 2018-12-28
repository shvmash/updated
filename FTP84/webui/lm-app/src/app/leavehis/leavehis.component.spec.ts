import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LeavehisComponent } from './leavehis.component';
import { RouterTestingModule } from '@angular/router/testing';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { EmployeeService } from '../employee.service';
import { HttpClient } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { of } from 'rxjs';
import {LeaveDetailsService } from '../leave-details.service';


const leavehis = {
  getLeaveHis(empId) {
    console.log('came inside the stub');
    const history =  [
      {
        "leaveId": 3,
        "empId": 69,
        "startDate": "2019-11-11",
        "endDate": "2019-11-11",
        "leaveNoOfDays": 1,
        "leaveType": "EL",
        "leaveStatus": "DENIED",
        "leaveReason": "Pregnant",
        "leaveAppliedOn": "2018-12-05",
        "mgrComments": "Bauaa"
      },
      {
        "leaveId": 10,
        "empId": 69,
        "startDate": "2019-12-12",
        "endDate": "2019-12-12",
        "leaveNoOfDays": 1,
        "leaveType": "EL",
        "leaveStatus": "Shaadi",
        "leaveReason": "SICK",
        "leaveAppliedOn": "2019-12-05",
        "mgrComments": "Bauaa"
      },
      {
        "leaveId": 23,
        "empId": 69,
        "startDate": "2021-12-12",
        "endDate": "2021-12-12",
        "leaveNoOfDays": 1,
        "leaveType": "EL",
        "leaveStatus": "APPROVED",
        "leaveReason": "BETI BHAG GAYI",
        "leaveAppliedOn": "2021-12-05",
        "mgrComments": "Bauaa"
      },
    ];
    return of( history );
  }
};

describe('LeavehisComponent', () => {
  let component: LeavehisComponent;
  let fixture: ComponentFixture<LeavehisComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({ 
      imports: [
        RouterTestingModule, FormsModule,HttpModule
      ],
      declarations: [ LeavehisComponent ],
      providers: [{provide: LeaveDetailsService,
        useValue: leavehis},
        HttpClient,
        HttpClientTestingModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LeavehisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });



  it('should Check Id for employee', () => {
    const fixture = TestBed.createComponent(LeavehisComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.hismock[0].empId).toEqual(69);
  });

  it('should Check leaveId for employee', () => {
    const fixture = TestBed.createComponent(LeavehisComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.hismock[0].leaveId).toEqual(3);
  });

  it('should Check startDate for employee', () => {
    const fixture = TestBed.createComponent(LeavehisComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.hismock[0].startDate).toEqual("2019-11-11");
  });

  it('should Check endDate for employee', () => {
    const fixture = TestBed.createComponent(LeavehisComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.hismock[0].endDate).toEqual("2019-11-11");
  });

  it('should Check leaveNoOfDays for employee', () => {
    const fixture = TestBed.createComponent(LeavehisComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.hismock[0].leaveNoOfDays).toEqual(1);
  });

  it('should Check leaveType for employee', () => {
    const fixture = TestBed.createComponent(LeavehisComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.hismock[0].leaveType).toEqual("EL");
  });

  it('should Check leaveStatus for employee', () => {
    const fixture = TestBed.createComponent(LeavehisComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.hismock[2].leaveStatus).toEqual("APPROVED");
  });


  it('should Check leaveReason for employee', () => {
    const fixture = TestBed.createComponent(LeavehisComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.hismock[2].leaveReason).toEqual("BETI BHAG GAYI");
  });

  it('should Check leaveAppliedOn for employee', () => {
    const fixture = TestBed.createComponent(LeavehisComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.hismock[2].leaveAppliedOn).toEqual("2021-12-05");
  });

  it('should Check mgrComments for employee', () => {
    const fixture = TestBed.createComponent(LeavehisComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.hismock[2].mgrComments).toEqual("Bauaa");
  });

  it('should render one employee record', async(() => {
  
    const fixture = TestBed.createComponent(LeavehisComponent);
    fixture.detectChanges();
    fixture.whenStable().then(() => {
      fixture.detectChanges();
      
      const compiled = fixture.debugElement.nativeElement;
      expect(compiled.querySelectorAll('.employee tr').length).toBe(3);
    });
  }));


  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
