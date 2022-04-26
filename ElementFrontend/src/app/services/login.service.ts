import { Injectable } from '@angular/core';
import {ApiService} from "./api.service";
import {UserInfoService} from "./user-info.service";
import {Router} from "@angular/router";
import {ITokenMessage} from "../models/ITokenMessage";


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(
    private api: ApiService,
    private router: Router,
    private userInfo: UserInfoService) { }

  login(login: string, password: string) {

    this.api.post<ITokenMessage>('api/auth/signin', {
      username: login,
      password: password
    }).subscribe(value => {

      if (value.token && value.token.length > 0){

        // console.log(value.token);
        this.userInfo.storeUserInfo(value.token);

        this.router.navigate(['page01']);
      }
    })
  }
}
