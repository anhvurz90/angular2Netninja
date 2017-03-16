import { DirectoryComponent } from './directory/directory.component';
import { HomeComponent } from './home/home.component';
import { provideRoutes } from '@angular/router';

const APP_ROUTES = [
  {path: '', component: HomeComponent},
  {path: 'directory', component: DirectoryComponent }
];

export const APP_ROUTES_PROVIDER = [
  provideRoutes(APP_ROUTES)
]
