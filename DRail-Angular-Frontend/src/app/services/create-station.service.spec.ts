import { TestBed, inject } from '@angular/core/testing';

import { CreateStationService } from './create-station.service';

describe('CreateStationService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CreateStationService]
    });
  });

  it('should be created', inject([CreateStationService], (service: CreateStationService) => {
    expect(service).toBeTruthy();
  }));
});
