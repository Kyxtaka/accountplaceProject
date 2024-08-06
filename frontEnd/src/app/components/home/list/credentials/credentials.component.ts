import { Component, OnInit, NgModule } from '@angular/core';
import { GlobalService } from '../../../../services/global/global.service';
import { Router, RouterOutlet } from '@angular/router';
import { DataService, CredAssociation, Credential, Group } from '../../../../services/data/data.service';
import { Observable } from 'rxjs';
import { CommonModule } from '@angular/common';
import { error } from 'console';

@Component({
  selector: 'app-credentials',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './credentials.component.html',
  styleUrl: './credentials.component.css'
})
export class CredentialsComponent implements OnInit {
  //fonctionnement
  private groupId: number | boolean =  false;
  private credAssocArray: CredAssociation[] = [];
  private allGroup: Group[] = [];

  //affichage
  public credentials: Credential[] = [];


  constructor(
    private globalService: GlobalService,
    private dataService: DataService,
    private router: Router
  ) {}

  //ajout des donner dans la liste credentials
  private addToCredentials(response: Observable<any>): void {
    response.subscribe({
        next: (data) => {
            const cred: Credential = {
                id: data['id'],
                email: data['email']['mailAddress'],
                identifier: data['username'],
                password: data['password'],
                a2f: data['a2f'],
                groupId: data['groupId'],
                platformId: data['plateformId']
            };
            this.credentials.push(cred);
        },
        error: (error) => {
            console.error("Error processing response:", error);
        },
        complete: () => {
            console.log("Data processing complete.");
        }
    });
  }

  ngOnInit(): void {

    this.groupId = this.globalService.getCurrentSelectedGroupId()!;
    if (this.globalService == null) {this.router.navigate(['/home'])}
    
    this.globalService.allGroup$.subscribe({
      next: (data) => {
        this.allGroup = data;
      },
      error: (error) => {
      }
    })

    this.allGroup.forEach( (group: Group) => {
      this.dataService.retrieveGroupCredAssociation(group.id).subscribe({
        next: (response) => {
          response.forEach((element: { [x: string]: any; }) => {
            const assoc: CredAssociation = {groupId: element['groupId'], credId: element['accountId']};
            this.credAssocArray.push(assoc);
            console.log("test credAssoc", assoc);
          });
          this.credAssocArray.forEach( assoc => {
            this.addToCredentials(this.dataService.retrieveCredential(assoc.credId));
          })
          console.log("cred Array:", this.credentials);
        },
        error: (error) => {
          console.log("Error while retrieving API response:", error);
        }
      })
    });
    
  }
  // this.credAssocArray
}
