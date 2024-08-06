import { Component, OnInit, NgModule } from '@angular/core';
import { GlobalService } from '../../../../services/global/global.service';
import { Router, RouterOutlet } from '@angular/router';
import { DataService, CredAssociation, Credential } from '../../../../services/data/data.service';
import { Observable } from 'rxjs';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-credentials',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './credentials.component.html',
  styleUrl: './credentials.component.css'
})
export class CredentialsComponent implements OnInit {
  private groupId: number | null =  null;
  public credentials: Credential[] = [];
  private credAssocArray: CredAssociation[] = []

  constructor(
    private globalService: GlobalService,
    private dataService: DataService,
    private router: Router
  ) {}

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
    this.groupId = this.globalService.getCurrentSelectedGroupId();
    if (this.groupId == null) {this.router.navigate(['/home'])}
    this.dataService.retrieveGroupCredAssociation(this.groupId!).subscribe({
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
  }
  // this.credAssocArray
}
