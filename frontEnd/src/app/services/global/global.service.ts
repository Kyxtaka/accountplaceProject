import { Injectable,  } from '@angular/core';
import { CredAssociation, UserData, Group, Privilege} from '../data/data.service';
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
  // private allCredentialDataSubject: BehaviorSubject<Credential[]>;

  //Observable user
  public isLogged$: Observable<Boolean>;
  public userData$: Observable<UserData | null>;

  public allCredAssociation$: Observable<CredAssociation[]>;
  public allGroup$: Observable<Group[]>;
  // public allCredential$: Observable<Credential[]>;
 

  constructor() {
    this.isLogged = new BehaviorSubject<boolean>(false);
    this.userDataSubject = new BehaviorSubject<UserData | null>(null);
    
    this.allCredAssociationSubject = new BehaviorSubject<CredAssociation[]>([]);
    this.allGroupsSubject = new BehaviorSubject<Group[]>([]);
    // this.allCredentialDataSubject = new BehaviorSubject<Credential[]>([]);

    this.isLogged$ = this.isLogged.asObservable();
    this.userData$ = this.userDataSubject.asObservable();

    this.allCredAssociation$ = this.allCredAssociationSubject.asObservable();
    this.allGroup$ = this.allGroupsSubject.asObservable();
    // this.allCredential$ = this.allCredentialDataSubject.asObservable();
  }


  //isLogged
  public updateIsLogged(data: boolean) { this.isLogged.next(data); }
  public getCurrentIsLogged(): boolean {return this.isLogged.getValue();}

  // userData
  public updateUserData(data: UserData | null): void {this.userDataSubject.next(data);}
  public getCurrentUserData(): UserData | null {return this.userDataSubject.getValue();}

  

  //CredAssoc
  public getCurrentCredAssocArray(): CredAssociation[] {return this.allCredAssociationSubject.getValue();}
  public updateCredAssocArray(data: CredAssociation): void {
    const tmp: CredAssociation[] = this.allCredAssociationSubject.getValue();
    if (!((data: CredAssociation) => tmp.some( elem => elem.groupId === data.groupId && elem.credId === data.credId))) {
      tmp.push(data);
    } 
    this.allCredAssociationSubject.next(tmp);
  }

  //Groups
  public getCurrentGroupsArray(): Group[] {return this.allGroupsSubject.getValue();}
  public updateGroupsArray(data: Group): void {
    const tmp: Group[] = this.allGroupsSubject.getValue();
    const execute: boolean = !tmp.some( elem => 
      elem.id === data.id &&
      elem.name === data.name &&
      elem.description === data.description &&
      elem.password === data.password
    )
    if (execute) {tmp.push(data)}
    this.allGroupsSubject.next(tmp);
  }

  //initalizer ==> 
  // public initConnection(response: Observable<any>): void {
  //   console.log('Authentification réussie', response);
  //         if (response != null) {
  //           let priv: Privilege = Privilege.USER;
  //           if (response["privilege"] == "admin") {priv = Privilege.ADMIN}; //recuperation privileges
  //           const userData: UserData = {userId: response["id"],username: response["username"], email: response["email"]["mailAddress"], privilege: priv};
  //           this.globalService.updateUserData(userData);
  //           console.log(this.globalService.getCurrentUserData());
  //     const userData: UserData = this.userDataSubject.getValue()!;
  // }
}
