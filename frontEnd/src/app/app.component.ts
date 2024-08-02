import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { LoginBoxComponent } from './login-box/login-box.component';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,HttpClientModule,LoginBoxComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'AccountSharePlaceApp';
}
