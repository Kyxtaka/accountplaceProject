import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GroupsapceComponent } from './groupsapce.component';

describe('GroupsapceComponent', () => {
  let component: GroupsapceComponent;
  let fixture: ComponentFixture<GroupsapceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GroupsapceComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GroupsapceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
