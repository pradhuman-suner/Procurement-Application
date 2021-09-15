import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyUserDashboardComponent } from './my-user-dashboard.component';

describe('MyUserDashboardComponent', () => {
  let component: MyUserDashboardComponent;
  let fixture: ComponentFixture<MyUserDashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MyUserDashboardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MyUserDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
