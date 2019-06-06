import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router } from '@angular/router';
import {TemplateView} from "../models/TemplateView";
import {TemplateviewService} from "../services/templateview.service";

@Component({
  selector: 'app-templateview-details',
  templateUrl: './templateview-details.component.html',
  styleUrls: ['./templateview-details.component.css']
})
export class TemplateviewDetailsComponent implements OnInit {
  template: TemplateView;
  isLoading = true;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private templateviewService: TemplateviewService) { }

  ngOnInit() {
    this.getTemplateViewDetails(this.route.snapshot.params['name']);
  }

  getTemplateViewDetails(id) {
    this.templateviewService.getTemplateViewByName(id)
      .subscribe(data => {
        this.template = data;
        console.log(data)
        this.isLoading = false;
      })
  }
}
