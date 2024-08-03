import { Injectable,  } from '@angular/core';
import { BehaviorSubject,Observable } from 'rxjs';

export enum Privilege {
  USER = "user",
  ADMIN = "admin"
}

export interface UserData {
  userId: number,
  username: string,
  email: string,
  privilege: Privilege 
}


@Injectable({
  providedIn: 'root'
})

export class LoginDataService {
  
  private userDataSubject: BehaviorSubject<UserData | null>;
  public userData$: Observable<UserData | null>;

  constructor() { 
    this.userDataSubject = new BehaviorSubject<UserData | null>(null);
    this.userData$ = this.userDataSubject.asObservable();
  }

    // Method to update the user data
  public updateUserData(data: UserData | null): void {
    this.userDataSubject.next(data);
  }
  
  public getCurrentUserData(): UserData | null {
    return this.userDataSubject.getValue();
  }

  public toString(userData: UserData): string {
    const result: string = "Attribut de valaur userData : \n" + 
              "userId : "+ userData.userId + "\n" + 
              "username : " + userData.username + "\n" +
              "email : " + userData.email + "\n" +
              "privilege : " + userData.privilege;
    return result;
  }

  public resetValueToNull(): void{
    this.userDataSubject.next(null);
  }
  
}
