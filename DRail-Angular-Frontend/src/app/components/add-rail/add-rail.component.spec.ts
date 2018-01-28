import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddRailComponent } from './add-rail.component';

describe('AddRailComponent', () => {
  let component: AddRailComponent;
  let fixture: ComponentFixture<AddRailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddRailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddRailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
