import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router } from '@angular/router';
import {PlatformTemplates} from "../models/PlatformTemplates";
import {PlatformTemplateService} from "../services/platform-template.service";

@Component({
  selector: 'app-platform-template-details',
  templateUrl: './platform-template-details.component.html',
  styleUrls: ['./platform-template-details.component.css']
})
export class PlatformTemplateDetailsComponent implements OnInit {
  platformTemplate: PlatformTemplates;
  isLoading= true;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private platformtemplateService: PlatformTemplateService) { }

  ngOnInit() {
    this.getPlatformTemplateDetails(this.route.snapshot.params['id']);
  }

  getPlatformTemplateDetails(id) {
    this.platformtemplateService.getPlatformTemplateById(id)
      .subscribe(data => {
        this.platformTemplate = data;
        this.isLoading = false;
      });
  }
}
