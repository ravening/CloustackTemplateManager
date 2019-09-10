import { Component, OnInit, ViewChild } from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import {TemplateView} from "../models/TemplateView";
import {TemplateviewService} from "../services/templateview.service";

@Component({
  selector: 'app-templateview',
  templateUrl: './templateview.component.html',
  styleUrls: ['./templateview.component.css']
})
export class TemplateviewComponent implements OnInit {
  data: TemplateView[] = [];
  isLoading = true;
  displayedColumns: string[] = ['name', 'displaytext'];
  dataSource: MatTableDataSource<TemplateView>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private templateviewService: TemplateviewService) { }

  ngOnInit() {
    this.templateviewService.getTemplateViews()
      .subscribe(res => {
        this.data = res;
        //console.log(this.data);
        this.isLoading = false;
        this.dataSource = new MatTableDataSource<TemplateView>(this.data);
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
