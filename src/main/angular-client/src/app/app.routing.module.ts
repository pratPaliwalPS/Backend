import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccuralruleListComponent } from '../accuralrule-list/accuralrule-list.component';
import {AddAccuralRule} from '../accuralrule-list/add-accuralrule.component';
const routes: Routes = [
  { path: 'add', component: AddAccuralRule }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }