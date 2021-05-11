import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AllSchedulesComponent } from './components/schedules/all-schedules/all-schedules.component';
import { TodoComponent } from './components/todo/todo.component';
import {HeaderComponent} from "./components/header/header/header.component";
import { FullScheduleComponent } from './components/schedules/full-schedule/full-schedule.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import { OrderByPipe } from './pipes/order-by.pipe';

const routes = [
  {
    path: 'schedules', component: AllSchedulesComponent,
  },
  {
    path: ':title', component: FullScheduleComponent
  }
]
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AllSchedulesComponent,
    TodoComponent,
    HeaderComponent,
    FullScheduleComponent,
    OrderByPipe,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes),

  ],

  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
