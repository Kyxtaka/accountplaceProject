import { Injectable,  } from '@angular/core';
import { BehaviorSubject,Observable } from 'rxjs';

enum Privilege {
  USER = "user",
  ADMIN = "admin"
}
interface UserData {
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
  
  public userData = new Observable<UserData|null>();
  
}
