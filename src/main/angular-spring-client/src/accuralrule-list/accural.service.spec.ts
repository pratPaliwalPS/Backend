import { TestBed, inject } from '@angular/core/testing';

import { AccuralService } from './accural.service';

describe('AccuralService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AccuralService]
    });
  });

  it('should be created', inject([AccuralService], (service: AccuralService) => {
    expect(service).toBeTruthy();
  }));
});
