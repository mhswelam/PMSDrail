import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddtilepopComponent } from './addtilepop.component';

describe('AddtilepopComponent', () => {
  let component: AddtilepopComponent;
  let fixture: ComponentFixture<AddtilepopComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddtilepopComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddtilepopComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
