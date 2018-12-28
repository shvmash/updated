 import { Injectable } from '@angular/core';
 import { Http,Response } from '@angular/http';
 import { Observable } from 'rxjs';
import 'rxjs/add/operator/map';
import { LeaveDetails } from './leave-details';
import { Pending } from './pending';
import { ApproveDeny } from './approve-deny';

@Injectable({
  providedIn: 'root'
})
export class LeaveDetailsService {

  constructor(private http : Http) { }
  applyLeave(leavedetails:LeaveDetails,empid : number):Observable<String> {
    return this.http.post('http://localhost:8080/ftp84/api/leaves/apply/' +empid,leavedetails)
     .map(response=>response.text()) 
   }

   pending(empId): Observable<Pending[]> {
    return this.http.get
    ("http://localhost:8080/ftp84/api/leaves/leapend/" + empId)
    .map((res : Response) => res.json());
   }


   getLeaveDetails(leaveId): Observable<LeaveDetails> {
    return this.http.get
    ("http://localhost:8080/ftp84/api/leaves/leaid/" + leaveId)
    .map((res : Response) => res.json());
   }

   getLeaveHis(empId) : Observable<LeaveDetails[]> {
    return this.http.get
    ("http://localhost:8080/ftp84/api/leaves/leahis/" + empId)
    .map((res : Response) => res.json());
   }

   approve(apprdeny:LeaveDetails,leaveId : number):Observable<String> {
    return this.http.post("http://localhost:8080/ftp84/api/leaves/appdeny/"+leaveId,apprdeny)
     .map(response=>response.text())
   }
}
