export class Todo {
  id: number | undefined;
  title: string;
  body: string;
  finalDate: Date;


  constructor(title: string, body: string, finalDate: Date) {
    this.title = title;
    this.body = body;
    this.finalDate = finalDate;
  }
}
