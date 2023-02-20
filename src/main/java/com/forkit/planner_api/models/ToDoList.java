package com.forkit.planner_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "toDoList")
public class ToDoList {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @OneToMany(mappedBy = "toDoList")
    @JsonIgnoreProperties({"toDoList"})
    private List<ToDoItem> items;

    @Column
    private LocalDate date;

    @Column
    private boolean isComplete;

    public ToDoList(Long id, LocalDate date, boolean completed) {
        this.id = id;
        this.items = new ArrayList<>();
        this.date = date;
        this.isComplete = false;

    }



    public ToDoList(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ToDoItem> getItems() {
        return items;
    }

    public void setItems(List<ToDoItem> items) {
        this.items = items;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}
