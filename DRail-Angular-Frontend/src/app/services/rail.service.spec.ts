import { TestBed, inject } from '@angular/core/testing';

import { RailService } from './rail.service';

describe('RailService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RailService]
    });
  });

  it('should be created', inject([RailService], (service: RailService) => {
    expect(service).toBeTruthy();
  }));
});
