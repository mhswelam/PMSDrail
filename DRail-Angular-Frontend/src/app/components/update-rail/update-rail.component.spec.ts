import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateRailComponent } from './update-rail.component';

describe('UpdateRailComponent', () => {
  let component: UpdateRailComponent;
  let fixture: ComponentFixture<UpdateRailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateRailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateRailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
