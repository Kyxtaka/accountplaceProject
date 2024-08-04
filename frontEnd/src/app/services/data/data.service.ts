import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginDataService, UserData } from '../loginDataService/login-data.service';

export interface Group {
  id: number,
  name: string,
  description: string,
  password: string,
};

@Injectable({
  providedIn: 'root'
})

export class DataService {

  private apiUrl = "http://localhost:8080/api/data"

  constructor(private http: HttpClient, private loginDataService: LoginDataService) { }

  retrieveUserData(): Observable<any> {
    return this.http.get(this.apiUrl+"/user/dto/"+this.loginDataService.getCurrentUserData()?.userId)
  }

  retriveGroup(groupId:number): Observable<any> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const params = new HttpParams().set("id", groupId);
    return this.http.get(this.apiUrl+"/group/dto",{ params });
  }

  retriveCredential(credentialId:number): Observable<any> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const params = new HttpParams().set("id", credentialId);
    return this.http.get(this.apiUrl+"/credential/dto", { headers, params });

  }


}
