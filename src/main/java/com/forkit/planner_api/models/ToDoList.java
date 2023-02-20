package com.forkit.planner_api.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class ToDoList {

    private Long id;
    private ArrayList<ToDoItem> items;
    private LocalDate date;

    public ToDoList(Long id, LocalDate date) {
        this.id = id;
        this.items = new ArrayList<>();
        this.date = date;
    }

    public ToDoList(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArrayList<ToDoItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<ToDoItem> items) {
        this.items = items;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
