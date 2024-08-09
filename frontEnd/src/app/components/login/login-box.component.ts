import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterOutlet, Router } from '@angular/router';
import { FormsModule, FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { GlobalService } from '../../services/global/global.service';
import { AuthService } from '../../services/auth/auth.service';
import { UserData, Privilege } from '../../services/data/data.service'

@Component({
  selector: 'app-login-box',
  standalone: true,
  imports: [CommonModule, RouterOutlet, FormsModule, ReactiveFormsModule], // Ajouter HttpClientModule ici
  templateUrl: './login-box.component.html',
  styleUrls: ['./login-box.component.css'] // Corriger la propriété en "styleUrls" au lieu de "styleUrl"
})
export class LoginBoxComponent implements OnInit {
  loginForm!: FormGroup;

  constructor(private formBuilder: FormBuilder, private authService: AuthService, private router: Router, private globalService: GlobalService) {}

  ngOnInit(): void {
    if (this.globalService.getCurrentUserData() != null) {
      this.router.navigate(['/home'])
    }
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
          if (response != null) {
            let priv: Privilege = Privilege.USER;
            if (response["privilege"] == "admin") {priv = Privilege.ADMIN}; //recuperation privileges
            const userData: UserData = {userId: response["id"],username: response["username"], email: response["email"]["mailAddress"], privilege: priv};
            this.globalService.updateUserData(userData);
            console.log(this.globalService.getCurrentUserData());
            this.globalService.updateIsLogged(true);
            this.router.navigate(['/home'])
            // initialisation de toutes les donnes apres authentification
          }else {
            console.log("Pas de compte utilisateur");
          }
          
        },
        error: (error) => {
          console.error('Erreur d\'authentification', error);
        }
      });
    }
  }
}