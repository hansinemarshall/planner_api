package com.forkit.planner_api.services;

import com.forkit.planner_api.models.ToDoItem;
import com.forkit.planner_api.models.ToDoList;
import com.forkit.planner_api.repositories.ToDoItemRepository;
import com.forkit.planner_api.repositories.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoListService {

    @Autowired
    ToDoListRepository toDoListRepository;

    @Autowired
    ToDoItemRepository toDoItemRepository;

    //-------------- TODOITEMS ---------------

    // add item
    public ToDoItem addItem (ToDoItem item){ return toDoItemRepository.save(item);}
    // find item by Id
    public ToDoItem findItemById (Long Id){
        return toDoItemRepository.findById(Id).get();
    }
    //display items
    public List<ToDoItem> findAllItems (){
        return toDoItemRepository.findAll();
    }

    //delete item
    public void deleteItem(Long listId, Long itemId) {
    ToDoItem itemToBeDeleted = toDoItemRepository.findById(itemId).get();
    ToDoList list = toDoListRepository.findById(listId).get();
    if(itemToBeDeleted.getToDoList().getId().equals(list.getId())) {
        toDoItemRepository.deleteById(itemId);
    } else {
        throw new RuntimeException("Item is not in list");
    }

    }

    // update item
    public void updateItem (ToDoItem item){ toDoItemRepository.save(item);}
    //filter item by priority

    //----------- TODOLIST ----------

    public void saveList (ToDoList list){ toDoListRepository.save(list);}


    //add toDoList
    public ToDoItem addItemToToDoList(Long toDoListId, ToDoItem newItem){
        ToDoList listToUpdate = toDoListRepository.findById(toDoListId).get();
//        ToDoItem newItem = findItemById(toDoItemId);
//        listToUpdate.getItems().add(newItem);
//        toDoItemRepository.save(newItem);
        return toDoItemRepository.save(newItem);

    }
    // find toDoList by Id
    public Optional<ToDoList>  findListById (Long Id){
        return toDoListRepository.findById(Id);
    }
    //display toDoList
    public List<ToDoList> findAllLists (){
        return toDoListRepository.findAll();
    }
    // filter toDoListByDate
    public List<ToDoList>filterToDoListByDate(LocalDate date){
        List<ToDoList> listsFilteredByDate = toDoListRepository.findByDate(date);
        return listsFilteredByDate;
    }
    //delete toDolIst
    public void deleteList(Long id){
        toDoListRepository.deleteById(id);
    }
    // show todolist is complete
    public List<ToDoList> getAllCompletedLists(){
        List<ToDoList> completedLists = toDoListRepository.findByIsCompleteTrue();
        return completedLists;
    }
    //update boolean method from false to true
    public ToDoItem updateItemCompletion(Long listId, Long itemId, boolean isCompleted){
        // create ToDoList variable
        //create ToDoItem variable
       ToDoList toDoList = toDoListRepository.findById(listId).get();
       ToDoItem toDoItem = toDoItemRepository.findById(itemId).get();
       toDoItem.setCompleted(isCompleted);
       //loop through items in the list
        boolean allCompleted = true;
        for (ToDoItem item : toDoList.getItems()){
            if (item.isCompleted()==false){
                allCompleted = false;
                break;
            }
        }
        toDoList.setComplete(allCompleted);
        toDoListRepository.save(toDoList);
       return toDoItemRepository.save(toDoItem);
    }


}
