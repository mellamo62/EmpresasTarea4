import {Routes} from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {DetailsComponent} from "./details/details.component";
import {CreateComponent} from "./create/create.component";


export const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'details/:id',
    component: DetailsComponent
  },
  {
    path: 'create',
    component: CreateComponent
  }
];
