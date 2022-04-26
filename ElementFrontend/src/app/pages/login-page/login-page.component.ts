import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {LoginService} from "../../services/login.service";

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss']
})
export class LoginPageComponent implements OnInit {

  login = '';
  password = '';

  constructor(
    private router: Router,
    private loginService: LoginService) {

  }

  ngOnInit(): void {
  }

  ExecuteLogin() {
    console.log(`user: ${this.login} password: ${this.password}`);

    this.loginService.login(this.login, this.password);
  }
}
