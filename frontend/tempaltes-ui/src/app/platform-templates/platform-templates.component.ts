import { Component, OnInit, ViewChild } from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import {PlatformTemplates} from "../models/PlatformTemplates";
import {PlatformTemplateService} from "../services/platform-template.service";

@Component({
  selector: 'app-platform-templates',
  templateUrl: './platform-templates.component.html',
  styleUrls: ['./platform-templates.component.css']
})
export class PlatformTemplatesComponent implements OnInit {
  data: PlatformTemplates[] = [];
  dataSource: MatTableDataSource<PlatformTemplates>;

  isLoading = true;
  displayedColumns: string[] = ['id', 'platformid', 'templateid'];
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;

  constructor(private platformtemplateService: PlatformTemplateService) { }

  ngOnInit() {
    this.platformtemplateService.getPlatformTemplates()
      .subscribe(res => {
        this.data = res;
        //console.log(this.data);
        this.isLoading = false;
        this.dataSource = new MatTableDataSource<PlatformTemplates>(this.data);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      }, error1 => {
        //console.log(error1);
        this.isLoading = false;
      });
  }


}
