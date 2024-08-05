import { Injectable,  } from '@angular/core';
import { UserData } from '../data/data.service';
import { BehaviorSubject,Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class GlobalService {
  private userDataSubject: BehaviorSubject<UserData | null>;
  public userData$: Observable<UserData | null>;
  private selectedGroupIdSubject: BehaviorSubject<number | null>

  constructor() { 
    this.userDataSubject = new BehaviorSubject<UserData | null>(null);
    this.selectedGroupIdSubject = new BehaviorSubject<number | null>(null);
    this.userData$ = this.userDataSubject.asObservable();
  }

    // Method to update the user data
  public updateUserData(data: UserData | null): void {
    this.userDataSubject.next(data);
  }
  
  public getCurrentUserData(): UserData | null {
    return this.userDataSubject.getValue();
  }

  public updateSelectedGroupId(data: number | null) {
    this.selectedGroupIdSubject.next(data);
  }

  public getCurrentSelectedGroupId(): number | null {
    return this.selectedGroupIdSubject.getValue();
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
