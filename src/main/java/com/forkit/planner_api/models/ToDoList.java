package com.forkit.planner_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Table(name = "toDoList")
public class ToDoList {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @OneToMany(mappedBy = "toDoList")
    @JsonIgnoreProperties({"toDoList"})
    private ArrayList<ToDoItem> items;

    @Column
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
