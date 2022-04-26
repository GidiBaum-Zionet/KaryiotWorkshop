import {Injectable} from '@angular/core';

export interface UserInStorage {
  userId: string;
  email: string;
  displayName: string;
  token: string;
}

export interface LoginInfoInStorage {
  success: boolean;
  message: string;
  landingPage: string;
  user?: UserInStorage;
}

@Injectable()
export class UserInfoService {

  public tokenKey = 'token';
  // public storage: Storage = sessionStorage; // <--- you may switch between sessionStorage or LocalStrage (only one place to change)
  public storage: Storage = localStorage; // <--- you may switch between sessionStorage or LocalStrage (only one place to change)

  constructor() {
  }

  // Store userinfo from session storage
  storeUserInfo(data: string) {
    this.storage.setItem(this.tokenKey, data);
  }

  // Remove userinfo from session storage
  removeUserInfo() {
    this.storage.removeItem(this.tokenKey);
  }

  isLoggedIn(): boolean {
    const token = this.storage.getItem(this.tokenKey);
    return !!(token && token.length > 0);
  }

  getStoredToken(): string | null {

    return this.storage.getItem(this.tokenKey);
  }
}
