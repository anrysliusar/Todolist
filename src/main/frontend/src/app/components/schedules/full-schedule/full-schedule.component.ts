import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Schedule} from "../../../models/schedule";
import {ActivatedRoute, Router} from "@angular/router";
import {ScheduleService} from "../../../services/schedule.service";
import {Todo} from "../../../models/todo";
import {TodoService} from "../../../services/todo.service";

@Component({
  selector: 'app-full-schedule',
  templateUrl: './full-schedule.component.html',
  styleUrls: ['./full-schedule.component.css'],
})
export class FullScheduleComponent implements OnInit {


  chosenSchedule: Schedule | undefined;

  title = "";
  body = "";
  finalDate: Date | undefined;
  options = [
    {name: "ascending id", field: "id"},
    {name: "descending id", field: "-id"},
    {name: "ascending finalDate (closest first)", field: "finalDate"},
    {name: "descending finalDate (closest last)", field: "-finalDate"}
  ]


  constructor(private router: Router, private activatedRoute: ActivatedRoute, private scheduleService: ScheduleService, private todoService: TodoService) {
    this.activatedRoute.params.subscribe(() => {
      this.chosenSchedule = this.router.getCurrentNavigation()?.extras.state as Schedule
    });
  }

  ngOnInit(): void {
    this.getById(this.chosenSchedule?.id)
  }

  addTodo() {
    if (this.finalDate && this.title && this.body) {
      const id = this.chosenSchedule?.id;
      const todo = new Todo(this.title, this.body, this.finalDate)
      this.todoService.addTodo(todo, id).subscribe(() => this.getById(id))
    } else {
      alert("Wrong input!")
    }
  }

  deleteTodo(todoId: any) {
    const id = this.chosenSchedule?.id
    this.todoService.deleteTodo(id, todoId).subscribe(() => this.getById(id))
  }

  getById(id: any): void {
    this.scheduleService.getById(id).subscribe(value => this.chosenSchedule = value)
  }

  apply() {
    this.getById(this.chosenSchedule?.id)
  }
}
