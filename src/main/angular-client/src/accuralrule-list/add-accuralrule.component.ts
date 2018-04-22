import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { Accuralrule } from './accuralrule.model';
import { AccuralService } from './accural.service';

@Component({
  templateUrl: './add-accuralrule.component.html',
  selector: 'add-accuralrule-list'
})
export class AddAccuralRule {
  
  accuralrule: Accuralrule = new Accuralrule();

  constructor(private router: Router, private accuralService: AccuralService) {

  }

  craeteAccuralRule(): void {
    this.accuralService.craeteAccuralRule(this.accuralrule)
        .subscribe( data => {
          alert("accuralrule created successfully.");
          this.accuralService.getAll().subscribe(
            data => {
               this.accuralrule = data;
               console.log(data);
             },
             error => console.log(error)
           );
        });
        

  };

  
}