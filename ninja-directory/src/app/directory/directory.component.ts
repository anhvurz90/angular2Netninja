import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { LoggingService } from '../logging.service';

@Component({
  selector: 'app-directory',
  templateUrl: './directory.component.html',
  styleUrls: ['./directory.component.css']
//  providers: [ LoggingService ]
})
export class DirectoryComponent implements OnInit {

  classes = {'blue': false, 'red': true, 'underline': true};

  test = false;

  ninjaObj: string;

  constructor(private route: ActivatedRoute, private logger: LoggingService) {
    this.ninjaObj = route.snapshot.params['ninja'];
  }

  logIt() {
    this.logger.log();
  }

  ngOnInit() {
  }

  ninjas = [
    {name: "Yoshi", belt: "black"},
    {name: "Ryu", belt: "red"},
    {name: "Crystal", belt: "purple"}
  ];

}
