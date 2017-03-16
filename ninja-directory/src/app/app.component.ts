import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'app works!, woop woop.';
  name = 'ninja';

  yell(e) {
    alert('I am yelling!');
    console.log(e);
  }

  ninja = {
    name : 'Vu',
    belt: 'Red'
  }
}
