import { TestBed } from '@angular/core/testing';

import { RecentDateService } from './recent-date.service';

describe('RecentDateService', () => {
  let service: RecentDateService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RecentDateService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
