import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Todo} from "../models/todo";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  URL = "http://localhost:8080/todoItems"
  constructor(private httpClient: HttpClient) { }

  update(todo: Todo, scheduleId: number): Observable<any>{
    return this.httpClient.put<Todo>(`${this.URL}/${scheduleId}/update/${todo.id}`, todo)
  }

  getAll(): Observable<any>{
    return this.httpClient.get<Todo>(this.URL)
  }

  getById(id: number): Observable<any>{
    return this.httpClient.get<any>(`${this.URL}/${id}`)
  }

  addTodo(todo: Todo, scheduleId: any): Observable<any>{
    return this.httpClient.post<Todo>(`${this.URL}/${scheduleId}/addTodo`, todo)
  }

  deleteTodo(scheduleId: any, todoId: number): Observable<any>{
    return this.httpClient.delete<any>(`${this.URL}/${scheduleId}/delete/${todoId}`)
  }
}
