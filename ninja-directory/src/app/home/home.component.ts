import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  homeTitle = 'Welcome to the ninja directory';
  myString = 'I like chicken';
  myBoolean = true;

  ninja = {
    name: 'Yoshi',
    belt: 'red'
  };

  @Input() ninjaParam;

  alertMe(msg) {
    alert(msg);
  };

  constructor() { }

  ngOnInit() {
  }

}
