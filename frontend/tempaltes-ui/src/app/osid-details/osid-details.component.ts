import { Component, OnInit } from '@angular/core';
import {Osid} from "../models/Osid";
import {ActivatedRoute, Router } from '@angular/router';
import {OsidService} from "../services/osid.service";

@Component({
  selector: 'app-osid-details',
  templateUrl: './osid-details.component.html',
  styleUrls: ['./osid-details.component.css']
})
export class OsidDetailsComponent implements OnInit {
  osid: Osid;
  isLoading = true;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private osidService: OsidService) { }

  ngOnInit() {
    this.getOsidDetails(this.route.snapshot.params['id']);
  }

  getOsidDetails(id) {
    this.osidService.getOsidById(id)
      .subscribe(data => {
        this.osid = data;
        this.isLoading = false;
      });
  }
}
