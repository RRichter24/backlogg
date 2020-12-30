import { TestBed } from '@angular/core/testing';

import { SessionStorageWrapperService } from './session-storage-wrapper.service';

describe('SessionStorageWrapperService', () => {
  let service: SessionStorageWrapperService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SessionStorageWrapperService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
