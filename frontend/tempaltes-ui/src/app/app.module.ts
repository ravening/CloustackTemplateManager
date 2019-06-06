import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TemplatesComponent } from './templates/templates.component';
import { TemplateDetailsComponent } from './template-details/template-details.component';
import { TemplateviewComponent } from './templateview/templateview.component';
import { TemplateviewDetailsComponent } from './templateview-details/templateview-details.component';
import { PlatformsComponent } from './platforms/platforms.component';
import { PlatformDetailsComponent } from './platform-details/platform-details.component';
import { PlatformTemplatesComponent } from './platform-templates/platform-templates.component';
import { PlatformTemplateDetailsComponent } from './platform-template-details/platform-template-details.component';
import { OsidComponent } from './osid/osid.component';
import { OsidDetailsComponent } from './osid-details/osid-details.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatInputModule, MatPaginatorModule, MatProgressSpinnerModule, MatSortModule, MatTableModule, MatIconModule, MatButtonModule, MatCardModule, MatFormFieldModule, MatTabsModule, MatListModule } from "@angular/material";
import {TemplateService} from "./services/template.service";
import {PlatformService} from "./services/platform.service";

@NgModule({
  declarations: [
    AppComponent,
    TemplatesComponent,
    TemplateDetailsComponent,
    TemplateviewComponent,
    TemplateviewDetailsComponent,
    PlatformsComponent,
    PlatformDetailsComponent,
    PlatformTemplatesComponent,
    PlatformTemplateDetailsComponent,
    OsidComponent,
    OsidDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatPaginatorModule,
    MatProgressSpinnerModule,
    MatSortModule,
    MatTableModule,
    MatIconModule,
    MatButtonModule,
    MatCardModule,
    MatFormFieldModule,
    MatTabsModule,
    MatListModule
  ],
  providers: [TemplateService, PlatformService],
  bootstrap: [AppComponent]
})
export class AppModule { }
