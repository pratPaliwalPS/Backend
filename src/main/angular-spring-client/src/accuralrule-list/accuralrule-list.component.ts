import { Component, OnInit } from '@angular/core';
import {AccuralService} from './accural.service';
import {Accuralrule} from './accuralrule.model';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-accuralrule-list',
  templateUrl: './accuralrule-list.component.html',
  providers: [AccuralService]
})
export class AccuralruleListComponent implements OnInit {
  accuralForm = new FormGroup({
    accrualRuleSeqNumber: new FormControl('', Validators.required),
    contractingparty: new FormControl('', Validators.required),
    contract: new FormControl('', Validators.required),	
    endUser: new FormControl('', Validators.required),		   
    status: new FormControl('', Validators.required),	
    isdeleted: new FormControl('', Validators.required),	
    updatedBy: new FormControl('', Validators.required),	
    updatedDate: new FormControl('', Validators.required)	
});
accuralIdToUpdate = null;
  accurals: Accuralrule[];
  constructor(private accuralService: AccuralService) { }
  ngOnInit():void {
    this.getAll();
}
getAll(){
  this.accuralService.getAll().subscribe(
    data => {
       this.accurals = data;
       console.log(data);
     },
     error => console.log(error)
    );
  }
  deleteAccuralRule(accrualRuleSeqNumber: number): void {
    this.accuralService.deleteAccuralRule(accrualRuleSeqNumber)
    .subscribe( data => {
      alert("order delete successfully");
      this.getAll();
  },
  error => console.log(error)
);
  }

  onAccuralFormSubmit() {
  
    let accural = this.accuralForm.value;
    
	  if (this.accuralIdToUpdate === null) {  
            this.accuralService.getAll()
	      .subscribe(accurals => {
          
		 
		   
		   //Create article
     	           this.accuralService.craeteAccuralRule(accural)
			  .subscribe(successCode => {
				   this.getAll();	
				 },
         error => console.log(error)
			   );
		 });		
	   } else {  
   	   
      accural.id = this.accuralIdToUpdate; 		
	     this.accuralService.updateAccuralRule(accural)
	        .subscribe(successCode => {
         this.getAll();	
         alert("update successful")
		},
    error => console.log(error)
  );
	   }
   }

   loadAccuralToEdit(accrualRuleSeqNumber: number) {
    this.accuralService.getAccuralById(accrualRuleSeqNumber)
   .subscribe(accural => {
            this.accuralIdToUpdate = accural.accrualRuleSeqNumber; 
            this.accuralForm.setValue({accrualRuleSeqNumber:accural.accrualRuleSeqNumber, contractingparty: accural.contractingparty, contract: accural.contract,endUser:accural.endUser,status: accural.status,isdeleted: accural.isdeleted,updatedBy:accural.updatedBy,updatedDate:null});
   },
   error => console.log(error)
  );
 }
  }
