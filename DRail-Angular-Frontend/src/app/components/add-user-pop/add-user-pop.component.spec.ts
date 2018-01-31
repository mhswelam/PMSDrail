import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddUserPopComponent } from './add-user-pop.component';

describe('AddUserPopComponent', () => {
  let component: AddUserPopComponent;
  let fixture: ComponentFixture<AddUserPopComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddUserPopComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddUserPopComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
