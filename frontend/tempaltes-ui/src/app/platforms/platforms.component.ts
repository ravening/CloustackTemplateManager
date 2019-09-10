import { Component, OnInit, ViewChild } from '@angular/core';
import {Platforms} from "../models/Platforms";
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import {PlatformService} from "../services/platform.service";

@Component({
  selector: 'app-platforms',
  templateUrl: './platforms.component.html',
  styleUrls: ['./platforms.component.css']
})
export class PlatformsComponent implements OnInit {
  data: Platforms[] = [];
  isLoading = true;

  displayedColumns: string[] = ['name', 'dc'];
  dataSource: MatTableDataSource<Platforms>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private platformService: PlatformService) { }

  ngOnInit() {
    this.platformService.getPlatforms()
      .subscribe(res => {
        this.data = res;
        this.isLoading = false;
        this.dataSource = new MatTableDataSource<Platforms>(this.data);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      }, error1 => {
        //console.log(error1);
        this.isLoading = false;
      });
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

}
