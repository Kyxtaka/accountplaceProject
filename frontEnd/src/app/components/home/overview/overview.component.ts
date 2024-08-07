import { Component, OnInit } from '@angular/core';
import { GlobalService } from '../../../services/global/global.service';
import { DataService } from '../../../services/data/data.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-overview',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './overview.component.html',
  styleUrl: './overview.component.css'
})
export class OverviewComponent implements OnInit {

  constructor (private globalService: GlobalService) {}

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }


  public groupCount: number | null = null;

}
