import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TemplatesComponent} from "./templates/templates.component";
import {TemplateDetailsComponent} from "./template-details/template-details.component";
import {PlatformsComponent} from "./platforms/platforms.component";
import {PlatformDetailsComponent} from "./platform-details/platform-details.component";
import {TemplateviewComponent} from "./templateview/templateview.component";
import {TemplateviewDetailsComponent} from "./templateview-details/templateview-details.component";
import {PlatformTemplatesComponent} from "./platform-templates/platform-templates.component";
import {PlatformTemplateDetailsComponent} from "./platform-template-details/platform-template-details.component";
import {OsidComponent} from "./osid/osid.component";
import {OsidDetailsComponent} from "./osid-details/osid-details.component";

const routes: Routes = [
  {
    path: '',
    component: TemplatesComponent
  },
  {
    path: 'templates',
    component: TemplatesComponent,
    data: { title: 'List of Templates'}
  },
  {
    path: 'templates/template-details/:id',
    component: TemplateDetailsComponent,
    data: { title: 'Template details'}
  },
  {
    path: 'platforms',
    component: PlatformsComponent,
    data: {title: 'List of platforms'}
  },
  {
    path: 'platforms/platform-details/:id',
    component: PlatformDetailsComponent,
    data: {title: 'Platform details'}
  },
  {
    path: 'templateviews',
    component: TemplateviewComponent,
    data: {title: 'List of template views'}
  },
  {
    path: 'templateviews/templateview-details/:name',
    component: TemplateviewDetailsComponent,
    data: {title: 'Template view details'}
  },
  {
    path: 'platformtemplates',
    component: PlatformTemplatesComponent,
    data: {title: 'List of platform templates'}
  },
  {
    path: 'platformtemplates/platformtemplate-details/:id',
    component: PlatformTemplateDetailsComponent,
    data: {title: 'List of platform templates'}
  },
  {
    path: 'osid',
    component: OsidComponent,
    data: {title: 'List of osid'}
  },
  {
    path: 'osid/osid-details/:id',
    component: OsidDetailsComponent,
    data: {title: 'Osid details'}
  },
  {
    path: 'platformtemplates/platforms/platform-details/:id',
    component: PlatformDetailsComponent,
    data: {title: 'Platform template details'}
  },
  {
    path: 'platformtemplates/templates/template-details/:id',
    component: TemplateDetailsComponent,
    data: {title: 'Platform template details'}
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
