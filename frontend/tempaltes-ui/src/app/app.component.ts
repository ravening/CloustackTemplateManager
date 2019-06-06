import { Component } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'tempalte-ui';

  navLinks: any[];
  activeIndex = -1;

  constructor(private router: Router) {
    this.navLinks = [
      {
        label: 'List Templates',
        link: './templates',
        index: 0
      }, {
        label: 'List Platforms',
        link: './platforms',
        index: 1
      }, {
        label: 'List Template views',
        link: './templateviews',
        index: 2
      }, {
        label: 'List Platform Templates',
        link: './platformtemplates',
        index: 3
      }, {
        label: 'List Osid',
        link: './osid',
        index: 4
      }
    ]

  }

  ngOnInit(): void {
    this.router.events.subscribe((res) => {
      this.activeIndex = this.navLinks.indexOf(this.navLinks.find(tab => tab.link === '.' + this.router.url));
    })
  }

}
