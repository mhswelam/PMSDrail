import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TilepopComponent } from './tilepop.component';

describe('TilepopComponent', () => {
  let component: TilepopComponent;
  let fixture: ComponentFixture<TilepopComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TilepopComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TilepopComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
