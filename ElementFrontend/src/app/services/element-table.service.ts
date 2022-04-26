import { Injectable } from '@angular/core';
import {ApiService} from "./api.service";
import {IElementModel} from "../models/IElementModel";


@Injectable({
  providedIn: 'root'
})
export class ElementTableService {

  elements: IElementModel[] = [];

  constructor(private api: ApiService) {
  }

  getElements(){

    try {
      this.api.get<IElementModel[]>('api/elements')
        .subscribe(value => {
          this.elements = value;
        });
    } catch (ex){
      console.log(ex);
    }

  }
}
