import { Component, OnInit } from '@angular/core';
import { GlobalService } from '../../services/global/global.service';
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

  groupId: number | null = this.globalService.getCurrentSelectedGroupId()
  credAssociation: CredAssociation | null = null;

  constructor(
    private globalService: GlobalService,
    private router: Router,
    private dataService: DataService
  ) {}

  ngOnInit(): void {
    if (this.groupId == null) {this.router.navigate(['/home'])}

  }
  

}
