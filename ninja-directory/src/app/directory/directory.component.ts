import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { LoggingService } from '../logging.service';
import { DataService } from '../data.service';
declare var firebase: any;

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

  constructor(private route: ActivatedRoute,
              private logger: LoggingService,
              private dataService: DataService) {
    this.ninjaObj = route.snapshot.params['ninja'];
  }

  logIt() {
    this.logger.log();
  }

  ngOnInit() {
    this.dataService.fetchData().subscribe(
      (data) => this.ninjas = data.json()
    );
    this.fbGetData();
  }

  ninjas = [
    {name: "Yoshi", belt: "black"},
    {name: "Ryu", belt: "red"},
    {name: "Crystal", belt: "purple"}
  ];

  fbGetData() {
    firebase.database().ref("/").on("child_added",
      (snapshot) => {
        console.log(snapshot.val());
        this.ninjas.push(snapshot.val());
      }
    );
  }

  fbPostData(name, belt) {
    firebase.database().ref("/").push({name: name, belt: belt});
  }
}
