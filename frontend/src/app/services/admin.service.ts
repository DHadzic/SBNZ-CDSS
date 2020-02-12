import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  private readonly path = 'http://localhost:8080/api/';

  constructor(private http: HttpClient) { }


  addSupstance(supstanceId){
    return this.http.put(this.path + "addSupstance/" + supstanceId,{responseType : 'text' as 'json'});
  }

  editSupstance(supstance){
    var headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

    return this.http.post(this.path + "editSupstance/", JSON.stringify(supstance),
          {headers, responseType : 'text' as 'json'});
  }

  deleteSupstance(supstanceId){
    return this.http.delete(this.path + "addSupstance/" + supstanceId,{responseType : 'text' as 'json'});
  }

}
