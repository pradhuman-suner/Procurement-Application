import { Component } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import {Observable} from 'rxjs';
declare var $: any;


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'procurementProj';
}
