import {Component, OnInit} from '@angular/core';
import {ScheduleService} from "../../../services/schedule.service";
import {Schedule} from "../../../models/schedule";
import {ActivatedRoute, Router} from "@angular/router";
import {Observable} from "rxjs";

@Component({
  selector: 'app-all-schedules',
  templateUrl: './all-schedules.component.html',
  styleUrls: ['./all-schedules.component.css']
})
export class AllSchedulesComponent implements OnInit {

  schedules: Schedule[] = []
  title = "";
  updatedTitle = "";
  isAvailable = false;


  constructor(private scheduleService: ScheduleService, private router: Router) {
  }


  ngOnInit(): void {
    this.getAllSchedules()
  }

  goToSchedules(schedule: any): void {
    this.router.navigate([schedule.title], {state: schedule});
  }

  getAllSchedules(): void {
    this.scheduleService.getAll().subscribe(value => this.schedules = value)
  }

  getById(id: number): Observable<Schedule>{
    return this.scheduleService.getById(id)

  }

  saveSchedule(): void {
    if (this.title){
      const date = new Date()
      const schedule = new Schedule(this.title, date, date, [])
      this.scheduleService.save(schedule).subscribe(() => this.getAllSchedules())
    }
  }


  deleteSchedule(id: any): void {
    this.scheduleService.deleteById(id).subscribe(() => this.getAllSchedules())
  }

  updateSchedule(id: any): void {
    if (!this.updatedTitle){
      alert("Enter new title!")
      return
    }
    let chosenSchedule = this.schedules.find(value => value.id = id)
    if (chosenSchedule) {
      chosenSchedule.title = this.updatedTitle
      chosenSchedule.updatedAt = new Date()
      this.scheduleService.update(chosenSchedule, id).subscribe(() => this.getAllSchedules())
    }
  }
}
