import { Component, OnInit, ViewEncapsulation} from '@angular/core';
import { Router, RouterModule, RouterOutlet } from '@angular/router';
import { CredAssociation, DataService } from '../../services/data/data.service';
import { GlobalService } from '../../services/global/global.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CommonModule,
    RouterOutlet,
    RouterModule
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
  encapsulation: ViewEncapsulation.None

})

export class HomeComponent implements OnInit{
  constructor(
    private router:Router, 
    private globalService: GlobalService,
    private dataService: DataService
  ) {}

  username: string = this.globalService.getCurrentUserData()!.username;
  ngOnInit(): void {
    if (this.globalService.getCurrentUserData() == null) {
      this.router.navigate(['/login'])
    }

    this.dataService.retrieveUserData().subscribe({
      next: (response) => {
            response["groups"].forEach((element: { [x: string]: any; }) => {
            let tempGroup = {
              id: element["id"], 
              name: element["name"], 
              description: element["description"], 
              password: element["password"]
            };
            this.globalService.updateGroupsArray(tempGroup);
          });
          console.log("API repsonse 'groups' :", this.globalService.getCurrentGroupsArray());
          console.log("state lenght:", this.globalService.getCurrentGroupsArray().length);
          for (let i=0; i < this.globalService.getCurrentGroupsArray().length ; i++) {
            this.dataService.retrieveGroup(this.globalService.getCurrentGroupsArray()[i].id).subscribe({
              next: (response) => {
                console.log("API response:", response);
              }, 
              error: (error) =>  {
                console.log("Error while executing API request:", error);
              }
            });
          }
          this.globalService.getCurrentGroupsArray().forEach( element => {
            this.dataService.retrieveGroupCredAssociation(element.id).subscribe({
              next: (response) => {
                response.forEach( (element: {[x:string]: any}) => {
                  const credTmp: CredAssociation = {groupId: element['groupId'], credId: element['accountId']};
                  this.globalService.updateCredAssocArray(credTmp);
                  console.log("Global credArray:", this.globalService.getCurrentCredAssocArray());
                }) 
              },
              error: (error) => {
                  console.log("Error while making credArray:", error);
              }
            })
          });
      },
      error: (error) => {
          console.log("Error while retrieving groups from the API:", error );
      }
    });
    
    

  }

  
}

