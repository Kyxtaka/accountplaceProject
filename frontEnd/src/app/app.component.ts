import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { LoginBoxComponent } from './login-box/login-box.component';

enum userPrivilege {
  ADMIN = "admin",
  USER = "user",
} 

interface User {
  id: number,
  authorization: userPrivilege 
}

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,LoginBoxComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})

export class AppComponent implements OnInit {
  title = 'AccountSharePlaceApp';
  user: User  | undefined;

  ngOnInit() {
    this.user = undefined;
  }

  initUser(user: User,id: number, auth: string) {
    user.id = id 
    if (auth == "admin") {
      user.authorization = userPrivilege.ADMIN;
    }else if (auth == "user") {
      user.authorization = userPrivilege.USER;
    }
  }

  getUser() {return this.user}
  
}