import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import {Accuralrule} from './accuralrule.model';
import 'rxjs/add/operator/map';
import { Http, Response, Headers, URLSearchParams, RequestOptions } from '@angular/http';

@Injectable()
export class AccuralService {

  constructor(private http: HttpClient) {}
  private userUrl = 'http://localhost:9090/OrderIntakeTool';
getAll(): Observable<any> {
    return this.http.get(this.userUrl + "/accrualrule");
  }

  public deleteAccuralRule(accrualRuleSeqNumber:number) {
    return this.http.delete(this.userUrl + "/delete/"+ accrualRuleSeqNumber);
  }
  public craeteAccuralRule(accuralrule:Accuralrule) {
    return this.http.post(this.userUrl + "/accrualrule", accuralrule);
  }
  updateAccuralRule(accuralrule: Accuralrule):Observable<any> {
          return this.http.put(this.userUrl + "/accrualrule/"+ accuralrule.accrualRuleSeqNumber, accuralrule);
      }
      getAccuralById(accrualRuleSeqNumber:number): Observable<any> {
        console.log(this.userUrl +"/accrualrule/"+ accrualRuleSeqNumber);
        return this.http.get(this.userUrl +"/accrualrule/"+ accrualRuleSeqNumber);
          }	
}