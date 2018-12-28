import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApproveDenyComponent } from './approve-deny.component';
import { RouterTestingModule } from '@angular/router/testing';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { EmployeeService } from '../employee.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

describe('ApproveDenyComponent', () => {
  let component: ApproveDenyComponent;
  let fixture: ComponentFixture<ApproveDenyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({ 
      imports: [
        RouterTestingModule, FormsModule,HttpModule
      ],
      declarations: [ ApproveDenyComponent ], 
      providers: [EmployeeService,
        HttpModule,
        HttpClientTestingModule],
      schemas : [
        CUSTOM_ELEMENTS_SCHEMA
      ],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApproveDenyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
