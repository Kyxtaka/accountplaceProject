import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { GlobalService } from '../global/global.service';

export interface UserData {
  userId: number,
  username: string,
  email: string,
  privilege: Privilege 
}
export interface CredAssociation {
  groupId: number,
  credId: number
};

export interface Credential {
  id: number,
  email: string,
  identifier: number,
  a2f: boolean,
  platformId: number,
  groupId: number
};

export interface Group {
  id: number,
  name: string,
  description: string,
  password: string,
};

export enum Privilege {
  USER = "user",
  ADMIN = "admin"
};

@Injectable({
  providedIn: 'root'
})

export class DataService {

  private apiUrl = "http://localhost:8080/api/data"

  constructor(private http: HttpClient, private global: GlobalService) { }

  retrieveUserData(): Observable<any> {
    return this.http.get(this.apiUrl+"/user/dto/"+this.global.getCurrentUserData()?.userId)
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
