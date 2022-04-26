import { Component, OnInit } from '@angular/core';
import {ApiService} from "../../services/api.service";
import {IMoleculeModel} from "../../models/IMoleculeModel";

@Component({
  selector: 'app-page02',
  templateUrl: './page02.component.html',
  styleUrls: ['./page02.component.scss']
})
export class Page02Component implements OnInit {

  formula = '';
  name = '';

  molecule: IMoleculeModel | undefined;


  constructor(private api: ApiService) { }

  ngOnInit(): void {
  }

  parseFormula() {

    const mul = {name: this.name, formula: this.formula};

    this.api.post<IMoleculeModel>(`api/material`, mul)
      .subscribe(value => {

        this.molecule = value;
      });

  }

}
