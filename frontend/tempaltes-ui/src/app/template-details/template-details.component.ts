import { Component, OnInit } from '@angular/core';
import {Templates} from "../models/Templates";
import {ActivatedRoute, Router } from '@angular/router';
import {TemplateService} from "../services/template.service";

@Component({
  selector: 'app-template-details',
  templateUrl: './template-details.component.html',
  styleUrls: ['./template-details.component.css']
})
export class TemplateDetailsComponent implements OnInit {
  template: Templates;
  isLoading = true;
  constructor(private route: ActivatedRoute,
              private router: Router,
              private templateService: TemplateService) { }

  ngOnInit() {
    this.getTemplateDetails(this.route.snapshot.params['id']);
  }

  getTemplateDetails(id) {
    this.templateService.getTemplateById(id)
      .subscribe(data => {
        this.template = data;
        this.isLoading = false;
      });
  }
}
