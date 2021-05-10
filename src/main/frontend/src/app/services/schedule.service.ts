import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Schedule} from "../models/schedule";
import {Todo} from "../models/todo";

@Injectable({
  providedIn: 'root'
})
export class ScheduleService {
  URL = "http://localhost:8080/schedules"
  constructor(private httpClient: HttpClient) { }


  getAll(): Observable<any>{
    return this.httpClient.get<Schedule[]>(this.URL)
  }

  getById(id: number): Observable<any>{
    return this.httpClient.get<Schedule>(`${this.URL}/${id}`)
  }

  save(schedule: Schedule): Observable<any> {
    return this.httpClient.post<Schedule>(`${this.URL}/save`, schedule)
  }

  update(schedule: Schedule, id: number): Observable<any>{
    return this.httpClient.put<Schedule>(`${this.URL}/${id}/update`, schedule)
  }

  deleteById(id: number): Observable<any>{
    return this.httpClient.delete<number>(`${this.URL}/${id}/delete`);
  }

  updateTodo(todo: Todo, scheduleId: any){
    return this.httpClient.put<Todo>(`${this.URL}/${scheduleId}/update/${todo.id}`, todo)
  }
}
