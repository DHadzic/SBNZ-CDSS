import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctorDiagnoseComponent } from './doctor-diagnose.component';

describe('DoctorDiagnoseComponent', () => {
  let component: DoctorDiagnoseComponent;
  let fixture: ComponentFixture<DoctorDiagnoseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DoctorDiagnoseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DoctorDiagnoseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
