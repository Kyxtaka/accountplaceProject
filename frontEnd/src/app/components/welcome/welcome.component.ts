import { Component, ViewEncapsulation, OnInit } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { GlobalService } from '../../services/global/global.service';
import { UserData } from '../../services/data/data.service';


@Component({
  selector: 'app-welcome',
  standalone: true,
  imports: [
    RouterModule,
    CommonModule,
    RouterOutlet
  ],
  templateUrl: './welcome.component.html',
  styleUrl: './welcome.component.css'
})
export class WelcomeComponent implements OnInit {
  public isLogged: boolean = false;
  public username: string | undefined;
  constructor (
    private globalService: GlobalService,
  ) {}


  ngOnInit(): void {
    this.globalService.isLogged$.subscribe({
      next: () => {
        this.isLogged = this.globalService.getCurrentIsLogged();
        console.log("isLogged status:", this.isLogged);
      }
    })

    this.globalService.userData$.subscribe({
      next: () => {
        this.username = this.globalService.getCurrentUserData()?.username
      }
    })
  }

}
