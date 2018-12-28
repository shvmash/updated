import { Injectable } from '@angular/core';
import { Http,Response} from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map';
import { Employee } from './employee';


@Injectable()
export class EmployeeService {
    constructor(private http: Http) {
    }

    getEmployees(): Observable<Employee[]> {
        return this.http.get
        ("http://localhost:8080/ftp84/api/employees")
        .map((res : Response) => res.json());
       }
    
       getEmpDetails(empId): Observable<Employee> {
        return this.http.get
        ("http://localhost:8080/ftp84/api/employees/" + empId)
        .map((res : Response) => res.json());
       }

}
