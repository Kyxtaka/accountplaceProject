import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule, FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from "../app.component"
import { AuthService } from '../auth.service';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-login-box',
  standalone: true,
  imports: [CommonModule, RouterOutlet, FormsModule, ReactiveFormsModule], // Ajouter HttpClientModule ici
  templateUrl: './login-box.component.html',
  styleUrls: ['./login-box.component.css'] // Corriger la propriété en "styleUrls" au lieu de "styleUrl"
})
export class LoginBoxComponent implements OnInit {
  loginForm!: FormGroup;

  constructor(private formBuilder: FormBuilder, private authService: AuthService, private mainComponent: AppComponent) {}

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      identifier: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  onSubmit(): void {
    if (this.loginForm.valid) {
      const { identifier, password } = this.loginForm.value;
      console.log('Données de connexion:', this.loginForm.value);
      this.authService.login(identifier, password).subscribe({
        next: (response) => {
          console.log('Authentification réussie', response);
        },
        error: (error) => {
          console.error('Erreur d\'authentification', error);
        }
      });
    }
  }
}