package com.forkit.planner_api.controllers;

import com.forkit.planner_api.models.ToDoItem;
import com.forkit.planner_api.models.ToDoList;
import com.forkit.planner_api.services.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todolist")
public class ToDoListController {
    @Autowired
    ToDoListService toDoListService;

    //POST

    @PostMapping
    public ResponseEntity<ToDoList> addNewList(@RequestBody ToDoList list) {
        toDoListService.saveList(list);
        return new ResponseEntity<>(list, HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Optional<ToDoList>> addItemToList(@RequestBody ToDoItem item, @PathVariable Long listId) {
        ToDoItem newItem = toDoListService.addItem(item);
        Long itemId = newItem.getId();
        Optional<ToDoList> listToAddItem = toDoListService.findListById(listId);
        toDoListService.addItemToToDoList(listId, itemId);
        return new ResponseEntity<>(listToAddItem, HttpStatus.CREATED);
    }

    //GET
    @GetMapping
    public ResponseEntity<List<ToDoList>> getAllListAndFilteredList(@RequestParam(name = "complete") Optional<Boolean> isComplete) {
        if (isComplete.isPresent()) {
            return new ResponseEntity<>(toDoListService.getAllCompletedLists(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(toDoListService.findAllLists(), HttpStatus.OK);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ToDoList> getListById(@PathVariable Long id) {
        Optional<ToDoList> list = toDoListService.findListById(id);
        if (list.isPresent()) {
            return new ResponseEntity<>(list.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //PATCH
    @PatchMapping(value = "/{listId}/item/{itemId}")
    public ResponseEntity<ToDoItem> updateItemCompletion(@RequestBody boolean completed, @PathVariable Long listId, @PathVariable Long itemId) {
        ToDoItem updatedItem = toDoListService.updateItemCompletion(listId, itemId, completed);
        return new ResponseEntity<>(updatedItem, HttpStatus.OK);
    }

    //DELETE ITEM
    @DeleteMapping(value = "/{listId}/item/{itemId}")
    public ResponseEntity deleteItem(@PathVariable Long listId, @PathVariable Long itemId) {
//        Long itemId = toDoListService.findItemById(id);
        toDoListService.deleteItem(listId, itemId);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteList(@PathVariable Long listId) {
//        Long itemId = toDoListService.findItemById(id);
        toDoListService.deleteList(listId);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}
