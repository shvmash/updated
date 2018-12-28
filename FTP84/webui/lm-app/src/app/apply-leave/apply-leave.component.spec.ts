import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { ApplyLeaveComponent } from './apply-leave.component';
import { FormsModule } from '@angular/forms';
import { EmployeeService } from 'src/app/employee.service';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { HttpModule} from '@angular/http'; 
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { HttpClient } from '@angular/common/http';
import { Http } from '@angular/http';
import { NgForm } from "@angular/forms";

describe('ApplyLeaveComponent', () => {
  let component: ApplyLeaveComponent;
  let fixture: ComponentFixture<ApplyLeaveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({ 
      imports: [
        RouterTestingModule, FormsModule,HttpModule
      ],
      declarations: [ ApplyLeaveComponent ], 
      providers: [EmployeeService,
        HttpModule,HttpClient,
        HttpClientTestingModule],
      schemas : [
        CUSTOM_ELEMENTS_SCHEMA
      ],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApplyLeaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
