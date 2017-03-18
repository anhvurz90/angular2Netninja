import { DirectoryComponent } from './directory/directory.component';
import { HomeComponent } from './home/home.component';
import { Routes } from '@angular/router';

export const APP_ROUTES: Routes = [
  {path: '', component: HomeComponent},
  {path: 'directory/:ninja', component: DirectoryComponent }
];
