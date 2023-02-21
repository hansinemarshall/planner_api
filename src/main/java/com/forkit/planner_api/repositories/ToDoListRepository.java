package com.forkit.planner_api.repositories;

import com.forkit.planner_api.models.ToDoItem;
import com.forkit.planner_api.models.ToDoList;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {
    List<ToDoList> findByDate (LocalDate date);
    List<ToDoList> findByIsCompleteTrue();
}
