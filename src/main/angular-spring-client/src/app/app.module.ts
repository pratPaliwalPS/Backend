import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import {AccuralService} from '../accuralrule-list/accural.service';
import { AccuralruleListComponent } from '../accuralrule-list/accuralrule-list.component';
import { HttpClientModule } from '@angular/common/http';
import {AddAccuralRule} from '../accuralrule-list/add-accuralrule.component';
import {AppRoutingModule } from './app.routing.module';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    AccuralruleListComponent,
    AddAccuralRule 
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule

  ],
  providers: [AccuralService],
  bootstrap: [AppComponent]
})
export class AppModule { }
