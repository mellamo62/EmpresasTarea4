/// <reference types="@angular/localize" />

import { bootstrapApplication } from '@angular/platform-browser';
import {routes} from "./app/app.routes";
import { AppComponent } from './app/app.component';
import {provideRouter} from "@angular/router";
import {provideHttpClient} from "@angular/common/http";

bootstrapApplication(AppComponent, {
  providers: [provideRouter(routes),
  provideHttpClient()]})
  .catch((err) => console.error(err));
