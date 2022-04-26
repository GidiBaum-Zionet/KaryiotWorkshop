import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Router} from "@angular/router";
import {UserInfoService} from "./user-info.service";

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(
    private http: HttpClient,
    private router: Router,
    private userInfoService: UserInfoService
  ) {
  }

  private getHeaders(): HttpHeaders {
    let headers = new HttpHeaders();
    const token = this.userInfoService.getStoredToken();
    headers = headers.append('Content-Type', 'application/json');
    if (token !== null) {
      headers = headers.append('Authorization', `Bearer ${token}`);
    }
    return headers;
  }

  get<T>(url: string, urlParams?: HttpParams): Observable<T>{
    return this.http.get<T>(url, {headers: this.getHeaders(), params: urlParams});
  }

  post<T>(url: string, body: any): Observable<T> {
    return this.http.post<T>(url, JSON.stringify(body), { headers: this.getHeaders()});
  }
}
