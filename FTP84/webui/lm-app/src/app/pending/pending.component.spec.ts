import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PendingComponent } from './pending.component';
import { RouterTestingModule } from '@angular/router/testing';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { LeavehisComponent } from '../leavehis/leavehis.component';
import { LeaveDetailsService } from '../leave-details.service';
import { HttpClient } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { of } from 'rxjs';
import { GrdFilterPipe } from 'src/app/grd-filter.pipe';



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
      }
    ];
    return of( employee );
  }
};



const leavepend = {
  pending(empId) {
    console.log('came inside the stub');
    const pending =  [
      {
        "leaveId": 3,
        "empId": 20,
        "startDate": "2019-11-11",
        "endDate": "2019-11-11",
        "leaveNoOfDays": 1,
        "leaveType": "EL",
        "leaveStatus": "PENDING",
        "leaveReason": "Pregnant",
        "leaveAppliedOn": "2018-12-05",
        "mgrComments": "Bauaa"
      },
      {
        "leaveId": 10,
        "empId": 20,
        "startDate": "2019-12-12",
        "endDate": "2019-12-12",
        "leaveNoOfDays": 1,
        "leaveType": "EL",
        "leaveStatus": "PENDING",
        "leaveReason": "SICK",
        "leaveAppliedOn": "2019-12-05",
        "mgrComments": "Bauaa"
      },
      {
        "leaveId": 23,
        "empId": 20,
        "startDate": "2021-12-12",
        "endDate": "2021-12-12",
        "leaveNoOfDays": 1,
        "leaveType": "EL",
        "leaveStatus": "PENDING",
        "leaveReason": "BETI BHAG GAYI",
        "leaveAppliedOn": "2021-12-05",
        "mgrComments": "Bauaa"
      },
    ];
    return of( pending );
  }
};

describe('PendingComponent', () => {
  let component: PendingComponent;
  let fixture: ComponentFixture<PendingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({ 
      imports: [
        RouterTestingModule, FormsModule,HttpModule
      ],
      declarations: [ PendingComponent, GrdFilterPipe  ],
      providers: [{provide: LeaveDetailsService,
        useValue: leavepend},
        HttpClient,
        HttpClientTestingModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PendingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });





  it('should Check Id for employee', () => {
    const fixture = TestBed.createComponent(PendingComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.pendmock[0].empId).toEqual(20);
  });
  
  it('should Check leaveId for employee', () => {
    const fixture = TestBed.createComponent(PendingComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.pendmock[0].leaveId).toEqual(3);
  });

  it('should Check startDate for employee', () => {
    const fixture = TestBed.createComponent(PendingComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.pendmock[2].startDate).toEqual("2021-12-12");
  });

  it('should Check endDate for employee', () => {
    const fixture = TestBed.createComponent(PendingComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.pendmock[2].endDate).toEqual("2021-12-12");
  });

  it('should Check leaveNoOfDays for employee', () => {
    const fixture = TestBed.createComponent(PendingComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.pendmock[2].leaveNoOfDays).toEqual(1);
  });

  it('should Check leaveType for employee', () => {
    const fixture = TestBed.createComponent(PendingComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.pendmock[2].leaveType).toEqual("EL");
  });


  it('should Check leaveStatus for employee', () => {
    const fixture = TestBed.createComponent(PendingComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.pendmock[2].leaveStatus).toEqual("PENDING");
  });


  it('should Check leaveReason for employee', () => {
    const fixture = TestBed.createComponent(PendingComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.pendmock[2].leaveReason).toEqual("BETI BHAG GAYI");
  });

  it('should Check leaveAppliedOn for employee', () => {
    const fixture = TestBed.createComponent(PendingComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.pendmock[2].leaveAppliedOn).toEqual("2021-12-05");
  });


  it('should Check mgrComments for employee', () => {
    const fixture = TestBed.createComponent(PendingComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.pendmock[2].mgrComments).toEqual("Bauaa");
  });




  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
