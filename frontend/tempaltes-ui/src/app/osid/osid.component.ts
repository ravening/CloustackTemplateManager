import { Component, OnInit, ViewChild } from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import {Osid} from "../models/Osid";
import {OsidService} from "../services/osid.service";
import {Templates} from "../models/Templates";

@Component({
  selector: 'app-osid',
  templateUrl: './osid.component.html',
  styleUrls: ['./osid.component.css']
})
export class OsidComponent implements OnInit {
  data: Osid[] = [];
  dataSource: MatTableDataSource<Osid>;
  isLoading = true;
  displayedColumns: string[] = ['name', 'displaytext'];
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private osidService: OsidService) { }

  ngOnInit() {
    this.osidService.getOsids()
      .subscribe(res => {
        this.data = res;
        //console.log(this.data);
        this.isLoading = false;
        this.dataSource = new MatTableDataSource<Osid>(this.data);
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
