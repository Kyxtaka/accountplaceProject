import { Injectable,  } from '@angular/core';
import { CredAssociation, UserData, Group } from '../data/data.service';
import { BehaviorSubject,Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class GlobalService {
  private userDataSubject: BehaviorSubject<UserData | null>;
  private selectedGroupIdSubject: BehaviorSubject<number | null>;
  private credAssociation: BehaviorSubject<CredAssociation[]>;
  private allGroupsSubject: BehaviorSubject<Group[]>;

  public userData$: Observable<UserData | null>;
  public selectedGroupId$: Observable<number | null>;
  public credAssociation$: Observable<CredAssociation[]>;
  public allGroup$: Observable<Group[]>;

  constructor() {
    this.credAssociation = new BehaviorSubject<CredAssociation[]>([]);
    this.userDataSubject = new BehaviorSubject<UserData | null>(null);
    this.selectedGroupIdSubject = new BehaviorSubject<number | null>(null);
    this.allGroupsSubject = new BehaviorSubject<Group[]>([]);

    this.userData$ = this.userDataSubject.asObservable();
    this.selectedGroupId$ = this.selectedGroupIdSubject.asObservable();
    this.credAssociation$ = this.credAssociation.asObservable();
    this.allGroup$ = this.allGroupsSubject.asObservable();
  }

  // userData
  public updateUserData(data: UserData | null): void {
    this.userDataSubject.next(data);
  }
  
  public getCurrentUserData(): UserData | null {
    return this.userDataSubject.getValue();
  }

  //GroupID
  public updateSelectedGroupId(data: number | null) {
    this.selectedGroupIdSubject.next(data);
  }

  public getCurrentSelectedGroupId(): number | null {
    return this.selectedGroupIdSubject.getValue();
  }

  //CredAssocArray
  public getCurrentCredAssocArray(): CredAssociation[] {
    return this.credAssociation.getValue();
  }

  public updateCredAssocArray(data: CredAssociation): void {
    const tmp: CredAssociation[] = this.credAssociation.getValue();
    tmp.push(data)
    this.credAssociation.next(tmp);
  }

  public getCurrentGroupsArray(): Group[] {
    return this.allGroupsSubject.getValue();
  }

  public updateGroupsArray(data: Group): void {
    const tmp: Group[] = this.allGroupsSubject.getValue();
    tmp.push(data)
    this.allGroupsSubject.next(tmp);
  }

  // public toString(userData: UserData): string {
  //   const result: string = "Attribut de valaur userData : \n" + 
  //             "userId : "+ userData.userId + "\n" + 
  //             "username : " + userData.username + "\n" +
  //             "email : " + userData.email + "\n" +
  //             "privilege : " + userData.privilege;
  //   return result;
  // }

  public resetValueToNull(): void{
    this.userDataSubject.next(null);
  }
  
}
