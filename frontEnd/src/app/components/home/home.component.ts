import { Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { LoginDataService, Privilege, UserData } from '../../services/loginDataService/login-data.service';
import { DataService, Group } from '../../services/data/data.service';
import { error } from 'console';
import { CommonModule } from '@angular/common';



@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CommonModule
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})

export class HomeComponent implements OnInit{
  groupsArray: Group[] = []
  userName: string = ""
  selectedGroup: number | null = null;

  constructor(private router:Router, private loginDataService: LoginDataService, private dataService: DataService) {}

  redirect(groupId:number): void {
    console.log("should redirect into group :", this.groupsArray[groupId].name, "component")
  }

  ngOnInit(): void {
    if (this.loginDataService.getCurrentUserData() == null) {
      this.router.navigate(['/login'])
    }
    

    this.dataService.retrieveUserData().subscribe({
      next: (response) => {
            this.userName = response["username"];
            response["groups"].forEach((element: { [x: string]: any; }) => {
            let tempGroup = {
              id: element["id"], 
              name: element["name"], 
              description: element["description"], 
              password: element["password"]
            };
            this.groupsArray.push(tempGroup);
          });
          console.log("API repsonse 'groups' :", this.groupsArray);
          console.log("state lenght:", this.groupsArray.length);
          for (let i=0; i < this.groupsArray.length ; i++) {
            this.dataService.retriveGroup(this.groupsArray[i].id).subscribe({
              next: (response) => {
                console.log("API response:", response);
              }, 
              error: (error) =>  {
                console.log("Error while executing API request:", error);
              }
            });
          }
      },
      error: (error) => {
          console.log("Error while retrieving groups from the API:", error );
      }
    });
  }
}

