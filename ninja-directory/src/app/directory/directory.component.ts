import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-directory',
  templateUrl: './directory.component.html',
  styleUrls: ['./directory.component.css']
})
export class DirectoryComponent implements OnInit {

  classes = {'blue': false, 'red': true, 'underline': true};

  test = false;

  ninjaObj: string;

  constructor(private route: ActivatedRoute) {
    this.ninjaObj = route.snapshot.params['ninja'];
  }

  ngOnInit() {
  }

  ninjas = [
    {name: "Yoshi", belt: "black"},
    {name: "Ryu", belt: "red"},
    {name: "Crystal", belt: "purple"}
  ];

}
