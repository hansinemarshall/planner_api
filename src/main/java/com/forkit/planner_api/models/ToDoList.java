package com.forkit.planner_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "toDoLists")
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



    public ToDoList(LocalDate date) {
        this.items = new ArrayList<>();
        this.date = date;
    }

    public boolean checkListIsCompleted(){
      return this.items.stream().allMatch(toDoItem -> toDoItem.isCompleted() == true);

    }

    public void addItemToList(ToDoItem toDoItem){
        this.items.add(toDoItem);
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

}
