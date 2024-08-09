import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiUrl = 'http://localhost:8080/api/service/auth/login'; // URL de votre endpoint d'authentification

  constructor(private http: HttpClient) { }

  login(identifier: string, password: string): Observable<any> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const body = { identifier, password };
    
    return this.http.post(this.apiUrl, body, { headers });
  }
}


