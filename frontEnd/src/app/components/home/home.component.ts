import { Component, OnInit} from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { GlobalService } from '../../services/global/global.service';
import { DataService, Group} from '../../services/data/data.service';
import { error } from 'console';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CommonModule,
    RouterOutlet
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})

export class HomeComponent implements OnInit{
  constructor(
    private router:Router, 
    private globalService: GlobalService, 
  ) {}

  ngOnInit(): void {
    if (this.globalService.getCurrentUserData() == null) {
      this.router.navigate(['/login'])
    }
  }
}

