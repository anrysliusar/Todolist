import {Component, Input, OnInit} from '@angular/core';
import {Todo} from "../../../models/todo";
import {TodoService} from "../../../services/todo.service";

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

  @Input()
  todo: Todo | undefined;

  @Input()
  scheduleId: number | undefined;


  updatedTitle = "";
  updatedBody = "";
  updatedDate: Date | undefined;
  isAvailable = false

  constructor(private todoService: TodoService) { }

  ngOnInit(): void {
  }

  updateTodo(): void{
    if (this.updatedTitle && this.updatedBody && this.updatedDate && this.todo && this.scheduleId){
      this.todo.title = this.updatedTitle;
      this.todo.body = this.updatedBody;
      this.todo.finalDate = this.updatedDate;
      this.todoService.update(this.todo, this.scheduleId).subscribe(() => this.getById(this.todo?.id))
    }else
      alert("Wrong input!")
  }

  getById(id: any): void{
    this.todoService.getById(id).subscribe(value => this.todo = value)
  }



}
