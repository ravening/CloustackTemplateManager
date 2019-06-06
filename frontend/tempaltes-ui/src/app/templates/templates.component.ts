import { Component, OnInit, ViewChild } from '@angular/core';
import {TemplateService} from "../services/template.service";
import {Templates} from "../models/Templates";
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';

@Component({
  selector: 'app-templates',
  templateUrl: './templates.component.html',
  styleUrls: ['./templates.component.css']
})
export class TemplatesComponent implements OnInit {
  data: Templates[] = [];
  isLoading = true;

  displayedColumns: string[] = ['name', 'displaytext', 'build', 'size'];
  dataSource: MatTableDataSource<Templates>;

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;

  constructor(private templateService: TemplateService) { }

  ngOnInit() {
    this.templateService.getTemplates()
      .subscribe(res => {
        this.data = res;
        this.isLoading = false;
        this.dataSource = new MatTableDataSource<Templates>(this.data);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      }, error1 => {
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
