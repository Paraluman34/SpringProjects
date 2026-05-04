import it from '@angular/common/locales/it';
import { Employee } from './employee';
import { describe } from 'node:test';

describe('Employee', () => {
  it('should create an instance', () => {
    expect(new Employee()).toBeTruthy();
  });
});
