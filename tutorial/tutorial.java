http://www.theNetNinja.co.uk/courses/angular-2-tutorials
1.Introduction: {
	1.1.What is Angular2: {
		- JavaScript framework for creating dynamic web apps
		- Component based (not typical MVC)
		- Written with TypeScript
		- Quite different from Angular1
	}
	1.2.Before you start: {
		- Node package manager
		- JavaScript / TypeScript
		- HTML / CSS
	}
	1.3.In This Playlist: {
		- Core features of Angular2 and how it works: {
			+ Components
			+ Directives
			+ Templates
		}
		- Create a simple directory app: {
			+ Routing
			+ Services
			+ Firebase
		}
	}
	1.4.Overview of the app: {
		- List ninjas
		- Add/remove ninjas
		- Filter ninjas
	}
	1.5.Atom: {
		- atom.io
		- packages: {
			+ platformio-ide-terminal
			+  language-typescript-grammar-only
		}
	}
	1.6. github.com/iamshaunjp/angular-2-playlist
}
2.Installing the Angular CLI : {
	2.1.The Angular CLI: {
		- Angular commands:
			+ Create new projects/ generate core file setup
			+ Spin up a local server
			+ Create new components
		- Requires Node Package Manager
	}
	2.2.Download NPM: nodejs.org
	2.3.Install Angular CLI: {
		- npm install -g angular-cli
	}
	2.4.Create project: {
		ng new ninja-directory
	}
	2.5.Spin up a local server: {
		- cd ninja-directory
		- ng serve
		-> localhost:4200
	}
}
3.Intro to TypeScript: {
	3.1.TypeScript 101: {
		- Superset of JavaScript
		- Very similar to JS, with a few additions: {
			+ Types
			+ Classes
			+ More...
		}
	}
	3.2.TypeScript Types: {
		- In regular JavaScript: {
			myVar = 'a string';
			myVar = 25;
		}
		- In TypeScript: {
			myVar = 'a String';
			myVar = 25; X => NOT ALLOWED.
		}
	}
	3.3.Declaring Types: {
		- myVar: string = 'hello';
		- myVar: number = 20;
		
		- myVar: boolean = true;
		
		- myVar: any;
		- myVar = 50;
		
		- myVar: number[]
	}
	3.4.Classes: {
		- class Car {
			wheels: number = 4;
			drive {
				console.log('the car is driving');
			}
		}
		- myCar: Car = new Car();
	}
	3.5.Constructor Functions: {
		- class Car {
			speed: number;
			constructor(mph: number) {
				this.speed = mph;
			}
		}
		- myCar: Car = new Car(70);
	}
}
4.Core Files Overview: {
	- src/ *.ts -> built -> dist/ *.js 
	- index.html 
	- app/app.component.css
		app.component.html
		app.component.spec.ts
		app.component.ts
		app.module.ts
}
5.Components: {
	- Components: 2.15: https://youtu.be/YKi2A2PFTnc?t=138
	{
		+ Root Component (app.component)
			+ Nav Component
			+ Blog Component
				+ Sidebar Component
				+ Article Component
		
		+ Each component: {
			* sidebar.component.ts: component logic
			* sidebar.component.html: component view
			* sidebar.component.css: component css
		}
	}
	- app.component.ts: {
		@Component({
			moduleId: module.id,
			selector: 'app-root',//-> index.html:<app-root></app-root>
			templateUrl: 'app.component.html',
			styleUrls: ['app.component.css']
		})
		
		export class AppComponent {
			title = 'app works!';//->app.component.html:{{title}}
		}
	}
}
6.Templates & CSS: {
	- 1st style: {
		@Component({
			moduleId: module.id,
			selector: 'app-root',
			templateUrl: 'app.component.html',
			styleUrls: ['app.component.css']
		})
	}
	- 2nd style: {
		@Component({
			template: '<h1>{{title}}</h1>',
		})
	}
	- CSS: {
		+ app.component.css 
			or
		+ ninja-directory/src/styles.css
	}
}
7.Creating a Component: {
	7.1.Structure: {
		- Root Component (app.component)
			+ Home Component (home.component)
	}
	7.2.Commands: {
		- cd ninja-directory/src/ *app*
		- ng generate component *home*// -> *home* under *app* 
		{
			ninja-directory/src/app/home/home.component.ts
									home.component.html
									home.component.css
									index.ts
		}
	}
	7.3.Insert Home section into app: {
		- app.component.html:
			<app-home></app-home>
	}
	
}
8.Nesting Components: {
	app.component.ts/app.module.ts: {
		import { HomeComponent } from './home/home.component';
		
		@Component({
			directives: [HomeComponent]
		})
	}
}
9.Ng-Content Directive {
	- home.component.html: {
		<p>
			home works!
		</p>
		<ng-content></ng-content>
	}
	- app.component.html: {
		<app-home>hello there!</app-home>
	}   
	---> html: {
		home works!
		hello there!
	}
}
10.Data Binding: {
	home.component.ts<-----DATA----->home.component.html
	10.1.Data Flow(Into the View) {
		- String interpolation:
			{{title}} (always resolves to a string)
		- Property binding:
			<input [required]='expression'>
	}
	10.2.Data Flow(Out of the View): {
		- Event binding:
			<button (click)='expression/function'>
			Component class can handle the event
	}
	10.3.Data Flow(Both ways) {
		- Two-way data binding
			+ <input [(ngModel)]='model/object'>
			+ Updates the model/object in the component class
			+ In turn updates any reference to the model/object
				in the view/template
				{{model}}
	}
	10.4.Coding: {
		- home.component.ts: {
			export class HomeComponent ... {
				homeTitle = 'Welcome to the ninja directory';
			}
		}
		- home.component.html: {
			{{homeTitle}}
		}
	}
}
11.Property Binding: {
	11.1.Property Binding {
		- Bind to HTML properties: {
			+ Native HTML properties: [value] = 'expression'
			+ Built in angular directives [ngClass]='expression'
			+ Custom-made properties: [myProp]='expression'
		}
	}
	11.2.: {
		- home.component.ts: {
			export class HomeComponent implements OnInit {
				myString = 'I like chicken';
				myBoolean = true;
			}
		}
		- home.component.html {
			<input [value]='myString'/>
			<input [required]='myBoolean'/>
		}
	}
}
12.Event Binding: {
	12.1.Event Binding: {
		- Bind events to HTML elements: {
			+ Bind to native events (such as click events) :
				<button (click) = 'function'>
			+ Bind to custom events we make:
				<app-home (update) = 'function'></app-home>
		}
	}
	12.2. {
		- home.component.html: {
			<button (click) = 'alertMe("I like beef")'>Click me</button>
		}
		- home.component.ts: {
			export class HomeComponent implements OnInit {
				alertMe(val) {
					alert(val);
				}
			}
		}
	}
}
13.2 Way Data Binding: {
	- home.component.ts: {
		export class HomeComponent implements OnInit {
			homeTitle = 'Welcome to the ninja directory!';
			ninja = {
				name: 'Yoshi',
				belt: 'Black'
			};
		}
	}
	- home.component.html: {
		<label>Name:</label>
		<input [(ngModel)] = 'ninja.name'/>
		<label>Belt:</label>
		<input [(ngModel)] = 'ninja.belt'/>
		<p>{{ninja.name}}</p>
		<p>{{ninja.belt}}</p>
	}
}
14.Custom Property Binding (& @Input): {
	- app.component.ts: {
		export class AppComponent {
			ninja = {
				name: 'Vu',
				belt: 'Black'
			}
		}
	}
	- app.component.html: {
		<app-home [ninjaParam]='ninja'>Hello there!</app-home>
	}
	
	- home.component.ts: {
		import {Input} from '@angular/core';
		export class HomeComponent implements OnInit {
			@Input() ninjaParam;
		}
	}
	- home.component.html: {
		<p>{{ninjaParam.name}}</p>
		<p>{{ninjaParam.belt}}</p>
	}
}
15.Custom Event Binding (& @Output): {
	- from Home -> Root component.
	- app.component.html: {
		<app-home [ninjaParam] = 'ninja'
				   (onYell) = 'yell($event)'>Hello there!</app-home>
	}
	
	- app.component.ts: {
		export class AppComponent {
			yell(e) {
				alert('I am yelling!');
				console.log(e);
			}
		}
	}
	
	- home.component.ts: {
		import { Output, EventEmitter} from '@angular/core';
		
		export class HomeComponent implements OnInit {
			@Output() onYell = new EventEmitter();
			
			fireYellEvent(e) {
				this.onYell.emit(e);
			}
		}
	}
	
	- home.component.html {
		<button (click) = 'fireYellEvent($event)'>Hit me</button> 
	}
}
16.Routing: {
	16.0.Updated tutorial: {
		https://angular.io/docs/ts/latest/guide/router.html
	}
	16.1.Routing: {
		- /
		- /home
		- /directory
		- /whatever
		All render the same view, because no routing has been set up
		
		We need:
		- / -> home view
		- /directory -> directory view
	}
	16.2.Setting up Routes: {
		2 STEPS: 
			+ Create a routes file, and export our routes so they can be
				loaded in the main.ts file
			+ Tell Angular where to load in our components / views when 
				a route is requested
	}
	16.3.Coding: {
		- Generate new component: {
			+ninja-directory/
				* ng generate component directory == ng g c directory
		}
		- src/app/app.routes.ts: {
			import { DirectoryComponent} from './directory/directory.component';
			import { HomeComponent} from './home/home.component';
			import { Routes } from '@angular/router';
			
			export const APP_ROUTES = [
				{path: '', component: HomeComponent},
				{path: 'directory', component: DirectoryComponent}	
			];				
		}
		- src/main.ts: {
		}
		- src/app/app.component.html: {
			+ remove <ap-home>...</app-home>
			+ add:
				<router-outlet></router-outlet>
		}
		- src/app/app.component.ts: {
		}
		- src/app/app.module.ts: {
			import { RouterModule } from '@angular/router';
			import { APP_ROUTES } from './app.routes';

			@NgModule({
			  imports: [
			    RouterModule.forRoot(APP_ROUTES)
			  ]
			})
		}
	}
}
17.Adding Links: {
	- updated tutorial:  {
		https://angular.io/docs/ts/latest/guide/router.html#!#basics-router-links
	}
	- src/index.html : {
		<head>
			<link href='/styles.css' rel='stylesheet' type='text/css'/>
			<!-- styles.css & logo.png are inside 'assets' folder-->
		</head>
	}
	- src/app/app.component.html: {
		<nav>
			<ul>
				<li><a href='/'>Home</a></li>
				<li><a href='/directory'>Directory</a></li>
			</ul>
		</nav>
		--->
				<li><a routerLink='/' routerLinkActive='active'>Home</a></li>
				<li><a routerLink='/directory' routerLinkActive='active'>Directory</a></li>
 	}
}
18.Route Params: {
	- src/app/app.routes.ts: {
		export const APP_ROUTES = {
			{ path: 'directory/:ninja', component: DirectoryComponent}
		}
	}
	
	- src/app/directory/directory.component.ts: {
		import { ActivatedRoute } from '@angular/router';
		
		export class DirectoryComponent implements OnInit {
			constructor(private route: ActivatedRoute) {
				this.ninjaObj = route.snapshot.params['ninja'];
			}
		}
	}
	
	- src/app/directory/directory.component.html: {
		<p>{{ninjaObj}}</p>
	}
		
}
19.Directives Introduction: {
	19.1.Directives: {
		- Directives are instructions which tell Angular to do something.
		- <router-outlet></router-outlet>
		- [routerLink]=''
	}
	19.2.Types of Directive: {
		- Attribute:
			+ Interacts with the element it's on to change it's properties.
			E.g: ngClass
		- Structural:
			+ Changes the structure of the HTML code.
			E.g: *ngIf
	}
	19.3.directory.component.html: {
		<p [ngClass]="classes">
			directory works!
		</p>
		
		<p *ngIf="test">Only show if test is true</p>
		<style>
			.blue {color: blue}
			.red {color: red}
			.underline {text-decoration: underline}
		</style>
	}
	19.4.directory.component.ts: {
		export class DirectoryComponent implements OnInit {
			classes = {'blue': false, 'red': true, 'underline': true};
			test = true;
		}
	}
}
20.ngFor: {
	20.1.directory.component.html: {
		<h2>Ninja Listing</h2>
		
		<ul id="ninja-listing">
			<li *ngFor="let ninja of ninjas">
				<div class="single-ninja">
					<span [ngStyle]="{background: ninja.belt}">
						{{ninja.belt}} belt
					</span>
					<h3>{{ninja.name}}</h3>
				</div>
			</li>
		</ul>
	}
	20.2.directory.component.ts: {
		export class DirectoryComponent implements OnInit {
			ninjas = [
				{name: "Yoshi", belt: "black"},
				{name: "Ryu", belt: "red"},
				{name: "Crystal", belt: "purple"}
			];
		}
	}
}
21.Pipes: {
	directory.component.html: {
		<h3>{{ninja.name | uppercase | slice:1:3}}</h3>
	}
}
22.Custom Filter Pipe: {
	22.1.Directory.component.html: {
		<form id="filter">
			<label>Filter ninjas by name:</label>
			<input type="text" [(ngModel)]="term"/>
		</form>
		
		<li *ngFor="let ninja of ninjas | ninjaFilter:term">
		</li>
	}
	22.2.Console: {
		- cd src/app
		- ng g pipe ninjaFilter (angular generate pipe with name 'ninjaFilter')
			---> src/app/ninjaFilter.pipe.ts
				src/app/ninjaFilter.pipe.spec.ts
	}
	22.3.ninjaFilter.pipe.ts: {
		import {Pipe, PipeTransform } from '@angular/core';
		
		@Pipe({
			name: 'ninjaFilter'
		})
		
		export class NinjaFilterPipe implements PipeTransform {
			
			transform(ninjaList: any, text: any): any {
				//check if search term is undefined
				if (term === undefined) return ninjaList;
				//return updated ninjaList 
				return ninjaList.filter(function(ninja) {
					return ninja.name.toLowerCase().includes(text.toLowerCase());
				});
			}
		}
	}
	22.4.app.module.ts: {
		import {NinjaFilterPipe} from './ninjaFilter.pipe';
		
		@NgModule({
			declarations: [
				...
				NinjaFilterPipe
			],
		})
	}
		
}
23.Services: {
	23.1.Don't Repeat Yourself: {
		Component 1:
			- Does something
			- Connects to the database
		Component 2:
			- Does something
			- Connects to the database
	}
	23.2.Services: {
		Component 1
			- Does something	----------------		Service
		Component 2					--------->		- Connects to database
			- Does something	----------------
	}
	23.3. {
		src/app:
			- ng g s logging (ng generate service 'logging')
			---> src/app/logging.service.ts: {
				import { Injectable } from '@angular/core';
				@Injectable()
				export class LoggingService {
					log() {
						console.log("I am the logging service.");
					}
					constructor() { }
				}
			}		
	}
	23.4.Directory.component.ts: {
		import { LoggingService } from "../logging.service";
		
		@Component({
			...
			providers: [ LoggingService ]
		})
		
		export class DirectoryComponent implements OnInit {
			constructor(private logger: LoggingService) {}
				
			logIt() {
				this.logger.log();
			}
		}
	}
	23.5.directory.component.html: {
		...
		<button (click)="logIt()">Log me</button>
	}
	23.6.A better way: {
		23.6.1.app.module.ts: {
			import { LoggingService } from "./app/logging.service";
			...
			@NgModule({
				declarations: [
					...
				],
				imports: [
					...
				],
				providers: [LoggingService],
				...
			})

		}
		23.6.2.directory.component.ts: {
			remove 'providers: [LoggingService]' from @Component({...})
		}
	}
}
24.HTTP Service: {
	24.1.assets/ninjas.json{
		[ {"name": "Yoshi", "belt": "black"},
		  {"name": "Ryu", "belt": "red"},
		  {"name": "Crystal", "belt": "purple"},
		  {"name": "Shaun", "belt": "black"} ]
	}
	24.2.src/app/directory/directory.component.ts: {
		import { DataService } from '../data.service';
		...
		export class DirectoryComponent implements OnInit {
			ninjas = [];
			
			constructor(private dataService: DataService) { }
			
			ngOnInit() {
				this.dataService.fetchData().subscribe(
					(data) => this.ninjas = data
				);
			}
		}
	}
	24.3.src/app/app.module.ts: {
		import { HttpModule } from '@angular/http';
		import { DataService } from 'data.service';
		...
		@NgModule({
			...
			imports: [
				...
				HttpModule
			]
			providers: [ DataService ]
		})
	}
	24.4.console {
		ng g s data
		---> src/app/data.service.ts {
			import { Injectable } from '@angular/core';
			import { Http } from '@angular/http';
			@Injectable()
			export class DataService {
				constructor(private http: Http) { }
				
				fetchData() {
					return this.http.get('/assets/ninjas.json')
					.map(
						(res) => res.json()
					);					
				}
			}
		}
	}
}