import { Component, OnInit } from '@angular/core';
import { Global } from '../../services/global/global.service';
import { Router } from '@angular/router';
import { DataService, CredAssociation } from '../../services/data/data.service';

@Component({
  selector: 'app-groupsapce',
  standalone: true,
  imports: [],
  templateUrl: './groupsapce.component.html',
  styleUrl: './groupsapce.component.css'
})

export class GroupsapceComponent implements OnInit{

  groupId: number | null = this.global.getCurrentSelectedGroupId()
  credAssociation: CredAssociation | null = null;

  constructor(
    private global: Global,
    private router: Router,
    private dataService: DataService
  ) {}

  ngOnInit(): void {
    if (this.groupId == null) {this.router.navigate(['/home'])}

  }
  

}
