package com.forkit.planner_api.components;

import com.forkit.planner_api.enums.Priority;
import com.forkit.planner_api.models.ToDoItem;
import com.forkit.planner_api.models.ToDoList;
import com.forkit.planner_api.repositories.ToDoItemRepository;
import com.forkit.planner_api.repositories.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ToDoListRepository toDoListRepository;
    @Autowired
    ToDoItemRepository toDoItemRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {


        // LIST
        ToDoList list1 = new ToDoList(LocalDate.of(2023,02,22));
        toDoListRepository.save(list1);
        ToDoList list2 = new ToDoList(LocalDate.of(2023,02,26));
        toDoListRepository.save(list2);
        ToDoList list3 = new ToDoList(LocalDate.of(2023,03,1));
        toDoListRepository.save(list3);

        // ITEMS
        ToDoItem item1 = new ToDoItem("New Task", list1, Priority.LOW);
        //item1.setPriority(Priority.LOW);
        toDoItemRepository.save(item1);

        ToDoItem item2 = new ToDoItem("Another Task", list1, Priority.MEDIUM);
        //item1.setPriority(Priority.LOW);
        toDoItemRepository.save(item2);

        ToDoItem item3 = new ToDoItem("New List, new Task", list2, Priority.HIGH);
        //item1.setPriority(Priority.MEDIUM);
        toDoItemRepository.save(item3);

        ToDoItem item4 = new ToDoItem("New Task", list3, Priority.LOW);
        //item1.setPriority(Priority.LOW);
        toDoItemRepository.save(item4);

        /*
        1. why is list id null (postman) but working elsewhere
        ^ we took out id from constructors
        2. how can we set priorities without using constructor
        ^we tried set method but resulted as null
        ^^ our patch method for updating priority works 
         */


    }
}
