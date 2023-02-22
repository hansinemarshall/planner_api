package com.forkit.planner_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.forkit.planner_api.enums.Priority;
import jakarta.persistence.*;

@Entity
@Table (name = "items")
public class ToDoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String task;

    @Enumerated(EnumType.ORDINAL)
    private Priority priority;

    @ManyToOne
    @JoinColumn(name = "toDoList_id")
    @JsonIgnoreProperties({"items"})
    private ToDoList toDoList;
    @Column
    private boolean isCompleted;

    public ToDoItem(Long id, String task, ToDoList toDoList) {
        this.id = id;
        this.task = task;
        this.toDoList = toDoList;
        this.isCompleted = false;
        this.priority = Priority.LOW;
    }

    public ToDoItem(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public ToDoList getToDoList() {
        return toDoList;
    }

    public void setToDoList(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        this.isCompleted = completed;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
