package com.forkit.planner_api.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ToDoListDTO {

    private Long id;
    private List<ToDoItem> items;
    private LocalDate date;
    private boolean isCompleted;

    public ToDoListDTO( List<ToDoItem> items, LocalDate date, boolean isCompleted) {

        this.items = items;
        this.date = date;
        this.isCompleted = isCompleted;
    }

    public ToDoListDTO() {
    }

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

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
