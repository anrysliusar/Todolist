import {Todo} from "./todo";

export class Schedule {
  id: number | undefined;
  title: string;
  createdAt: Date;
  updatedAt: Date;
  todoList: Todo[];

  constructor(title: string, createdAt: Date, updatedAt: Date, todoList: Todo[]) {
    this.title = title;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.todoList = todoList;
  }
}
