import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {NavbarComponent} from "./components/navbar/navbar.component";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatButtonModule} from "@angular/material/button";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatIconModule} from "@angular/material/icon";
import {MatInputModule} from "@angular/material/input";
import {MatTableModule} from "@angular/material/table";
import { Page01Component } from './pages/page01/page01.component';
import { Page02Component } from './pages/page02/page02.component';
import { Page03Component } from './pages/page03/page03.component';
import {PageNotFoundComponent} from "./pages/page-not-found/page-not-found.component";
import { LoginPageComponent } from './pages/login-page/login-page.component';
import {AuthGuard} from "./services/auth_guard.service";
import {UserInfoService} from "./services/user-info.service";
import {AppRoutingModule} from "./app-routing.module";
import {ElementTableService} from "./services/element-table.service";

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    Page01Component,
    Page02Component,
    Page03Component,
    PageNotFoundComponent,
    LoginPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatToolbarModule,
    MatIconModule,
    MatInputModule,
    MatTableModule,
  ],
  providers: [UserInfoService, AuthGuard, ElementTableService],
  bootstrap: [AppComponent]
})
export class AppModule { }
