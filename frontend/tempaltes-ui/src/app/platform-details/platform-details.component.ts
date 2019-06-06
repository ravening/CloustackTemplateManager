import { Component, OnInit } from '@angular/core';
import {Platforms} from "../models/Platforms";
import {PlatformService} from "../services/platform.service";
import {ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-platform-details',
  templateUrl: './platform-details.component.html',
  styleUrls: ['./platform-details.component.css']
})
export class PlatformDetailsComponent implements OnInit {

  constructor(private route: ActivatedRoute,
              private router: Router,
              private platformService: PlatformService) { }

  platform: Platforms;
  isLoading = true;
  ngOnInit() {
    this.getPlatformDetails(this.route.snapshot.params['id']);
  }

  getPlatformDetails(id) {
    this.platformService.getPlatformById(id)
      .subscribe(data => {
        this.platform = data;
        this.isLoading = false;
      })
  }
}
