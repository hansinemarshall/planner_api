package com.forkit.planner_api.components;

import com.forkit.planner_api.enums.Priority;
import com.forkit.planner_api.enums.Topic;
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
        ToDoList list1 = new ToDoList(LocalDate.of(2023,02,22), Topic.SHOPPING_LIST);
        toDoListRepository.save(list1);
        ToDoList list2 = new ToDoList(LocalDate.of(2023,02,26),Topic.DO_NOT_FORGET);
        toDoListRepository.save(list2);
        ToDoList list3 = new ToDoList(LocalDate.of(2023,03,1), Topic.BUCKET_LIST);
        toDoListRepository.save(list3);

        // ITEMS
        ToDoItem item1 = new ToDoItem("Your first Shopping List", list1);
        toDoItemRepository.save(item1);

        ToDoItem item2 = new ToDoItem("Add as many items as you would like... and don't forget to update each item's priority rating", list1);
        toDoItemRepository.save(item2);

        ToDoItem item3 = new ToDoItem("You can create multiple To Do Lists for different types of task/list", list2);
        toDoItemRepository.save(item3);

        ToDoItem item4 = new ToDoItem("Bucket List", list3);
        toDoItemRepository.save(item4);


    }
}
