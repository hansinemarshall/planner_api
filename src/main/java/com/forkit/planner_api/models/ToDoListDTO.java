package com.forkit.planner_api.models;

import com.forkit.planner_api.enums.Topic;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;
import java.util.List;

public class ToDoListDTO {

    private Long id;
    private List<ToDoItem> items;
    private LocalDate date;
    private boolean isCompleted;
    private String topic;

    public ToDoListDTO(Long id, List<ToDoItem> items, LocalDate date, boolean isCompleted, String topic) {
        this.id = id;
        this.items = items;
        this.date = date;
        this.isCompleted = isCompleted;
        this.topic = topic;
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

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
