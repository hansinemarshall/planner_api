package com.forkit.planner_api.controllers;

import com.forkit.planner_api.enums.Priority;
import com.forkit.planner_api.models.ToDoItem;
import com.forkit.planner_api.models.ToDoList;
import com.forkit.planner_api.models.ToDoListDTO;
import com.forkit.planner_api.services.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todolists")
public class ToDoListController {
    @Autowired
    ToDoListService toDoListService;

    //POST
    @PostMapping
    public ResponseEntity<ToDoList> addNewList(@RequestBody ToDoList list) {
        toDoListService.saveList(list);
        return new ResponseEntity<>(list, HttpStatus.CREATED);
    }

    @PostMapping("/{listId}")
    public ResponseEntity<ToDoItem> addItemToList(@RequestBody ToDoItem item, @PathVariable Long listId) {
        toDoListService.addItemToToDoList(listId, item);
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    //GET
    @GetMapping
    public ResponseEntity<List<ToDoListDTO>> getAllListAndFilteredList(@RequestParam(name = "complete") Optional<Boolean> isComplete) {
        if (isComplete.isPresent()) {
            return new ResponseEntity<>(toDoListService.getAllCompletedLists(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(toDoListService.findAllLists(), HttpStatus.OK);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ToDoListDTO> getListById(@PathVariable Long id) {
        ToDoListDTO list = toDoListService.findListById(id);
        if (list != null) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //PATCH
    @PatchMapping(value = "/{listId}/item/{itemId}")
    public ResponseEntity<ToDoItem> updateItemCompletion(@RequestBody Boolean isCompleted, @PathVariable Long listId, @PathVariable Long itemId) {
       ToDoItem updatedItem = toDoListService.updateItemCompletion(itemId, isCompleted);
        return new ResponseEntity<>(updatedItem, HttpStatus.OK);
    }

    @PatchMapping(value = "/item/{itemId}")
    public ResponseEntity<ToDoItem> changeItemPriority(@RequestBody Priority priority , @PathVariable Long itemId) {
        ToDoItem item = toDoListService.changeItemPriority(itemId, priority);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping(value = "/{listId}/item/{itemId}")
    public ResponseEntity deleteItem(@PathVariable Long listId, @PathVariable Long itemId) {
        toDoListService.deleteItem(listId, itemId);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/{listId}")
    public ResponseEntity deleteList(@PathVariable Long listId) {
        toDoListService.deleteList(listId);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}
