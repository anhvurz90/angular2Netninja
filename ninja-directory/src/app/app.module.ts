import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { DirectoryComponent } from './directory/directory.component';
import { RouterModule } from '@angular/router';
import { APP_ROUTES } from './app.routes';
import { NinjaFilterPipe } from './ninja-filter.pipe';
import { LoggingService } from './logging.service';
//import { HTTP_PROVIDERS } from "@angular/http";
import { DataService} from './data.service';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    DirectoryComponent,
    NinjaFilterPipe
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(APP_ROUTES)
  ],
  providers: [LoggingService, DataService ],
  bootstrap: [AppComponent],
})
export class AppModule { }
