import { Component, OnInit } from '@angular/core';
import {ElementTableService} from "../../services/element-table.service";

@Component({
  selector: 'app-page01',
  templateUrl: './page01.component.html',
  styleUrls: ['./page01.component.scss']
})
export class Page01Component implements OnInit {

  constructor(public elementTable: ElementTableService) {
  }

  ngOnInit(): void {
  }

  load(){
    this.elementTable.getElements();
  }
}
