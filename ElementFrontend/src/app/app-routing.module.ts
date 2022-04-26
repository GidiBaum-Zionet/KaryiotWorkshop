import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {Page01Component} from "./pages/page01/page01.component";
import {Page02Component} from "./pages/page02/page02.component";
import {Page03Component} from "./pages/page03/page03.component";
import {PageNotFoundComponent} from "./pages/page-not-found/page-not-found.component";
import {LoginPageComponent} from "./pages/login-page/login-page.component";
import {AuthGuard} from "./services/auth_guard.service";

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginPageComponent},
  { path: 'page01', component: Page01Component, canActivate: [AuthGuard]},
  { path: 'page02', component: Page02Component,  canActivate: [AuthGuard]},
  { path: 'page03', component: Page03Component,  canActivate: [AuthGuard]},
  { path: '**', component: PageNotFoundComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
