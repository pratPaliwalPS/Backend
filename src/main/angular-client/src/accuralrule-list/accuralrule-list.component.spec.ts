import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AccuralruleListComponent } from './accuralrule-list.component';

describe('AccuralruleListComponent', () => {
  let component: AccuralruleListComponent;
  let fixture: ComponentFixture<AccuralruleListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AccuralruleListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AccuralruleListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
