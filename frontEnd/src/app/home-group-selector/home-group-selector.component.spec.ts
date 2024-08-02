import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeGroupSelectorComponent } from './home-group-selector.component';

describe('HomeGroupSelectorComponent', () => {
  let component: HomeGroupSelectorComponent;
  let fixture: ComponentFixture<HomeGroupSelectorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HomeGroupSelectorComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HomeGroupSelectorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
