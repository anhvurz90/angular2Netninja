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