package com.sliusar.todolist.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString(exclude = "schedule")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String body;
    private Date finalDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Schedule schedule;


}
