import { TestBed, inject } from '@angular/core/testing';

import { GetStationsService } from './get-stations.service';

describe('GetStationsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GetStationsService]
    });
  });

  it('should be created', inject([GetStationsService], (service: GetStationsService) => {
    expect(service).toBeTruthy();
  }));
});
