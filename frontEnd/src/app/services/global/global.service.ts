import { Injectable,  } from '@angular/core';
import { CredAssociation, UserData, Group, } from '../data/data.service';
import { BehaviorSubject,Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class GlobalService {
  //Login data + status
  private isLogged: BehaviorSubject<boolean>;
  private userDataSubject: BehaviorSubject<UserData | null>;
  //exploitation Data
  private allCredAssociationSubject: BehaviorSubject<CredAssociation[]>;
  private allGroupsSubject: BehaviorSubject<Group[]>;
  private allCredentialDataSubject: BehaviorSubject<Credential[]>;

  //Observable user
  public isLogged$: Observable<Boolean>;
  public userData$: Observable<UserData | null>;

  public allCredAssociation$: Observable<CredAssociation[]>;
  public allGroup$: Observable<Group[]>;
  public allCredential$: Observable<Credential[]>;
 

  constructor() {
    this.isLogged = new BehaviorSubject<boolean>(false);
    this.userDataSubject = new BehaviorSubject<UserData | null>(null);
    
    this.allCredAssociationSubject = new BehaviorSubject<CredAssociation[]>([]);
    this.allGroupsSubject = new BehaviorSubject<Group[]>([]);
    this.allCredentialDataSubject = new BehaviorSubject<Credential[]>([]);

    this.isLogged$ = this.isLogged.asObservable();
    this.userData$ = this.userDataSubject.asObservable();

    this.allCredAssociation$ = this.allCredAssociationSubject.asObservable();
    this.allGroup$ = this.allGroupsSubject.asObservable();
    this.allCredential$ = this.allCredentialDataSubject.asObservable();
  }


  //isLogged
  public updateSelectedGroupId(data: boolean) { this.isLogged.next(data); }
  public getCurrentSelectedGroupId(): boolean {return this.isLogged.getValue();}

  // userData
  public updateUserData(data: UserData | null): void {this.userDataSubject.next(data);}
  public getCurrentUserData(): UserData | null {return this.userDataSubject.getValue();}

  

  //CredAssoc
  public getCurrentCredAssocArray(): CredAssociation[] {return this.allCredAssociationSubject.getValue();}
  public updateCredAssocArray(data: CredAssociation): void {
    const tmp: CredAssociation[] = this.allCredAssociationSubject.getValue();
    tmp.push(data);
    this.allCredAssociationSubject.next(tmp);
  }

  //Groups
  public getCurrentGroupsArray(): Group[] {return this.allGroupsSubject.getValue();}
  public updateGroupsArray(data: Group): void {
    const tmp: Group[] = this.allGroupsSubject.getValue();
    tmp.push(data)
    this.allGroupsSubject.next(tmp);
  }

  //initalizer ==> 
  public init(): void {
      const userData: UserData = this.userDataSubject.getValue()!;
  }
}
