import { Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { LoginDataService, UserData } from '../../services/loginDataService/login-data.service';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit{

  constructor(private router:Router, private loginDataService: LoginDataService) {}

  ngOnInit(): void {
    if (this.loginDataService.getCurrentUserData() == null) {
      this.router.navigate(['/login'])
    }
  }

}
