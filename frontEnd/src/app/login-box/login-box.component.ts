import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule ,FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterOutlet } from '@angular/router';


@Component({
  selector: 'app-login-box',
  standalone: true,
  imports: [CommonModule,RouterOutlet, FormsModule, ReactiveFormsModule],
  templateUrl: './login-box.component.html',
  styleUrl: './login-box.component.css'
})

export class LoginBoxComponent implements OnInit {
  loginForm!: FormGroup;

  constructor(private formBuilder: FormBuilder) {}

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  onSubmit(): void {
    if (this.loginForm.valid) {
      const loginData = this.loginForm.value;
      console.log('Données de connexion:', loginData);
    }
  }
}
