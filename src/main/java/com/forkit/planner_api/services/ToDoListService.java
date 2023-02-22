package com.forkit.planner_api.services;

import com.forkit.planner_api.models.ToDoItem;
import com.forkit.planner_api.models.ToDoList;
import com.forkit.planner_api.models.ToDoListDTO;
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
    }else {
        throw new RuntimeException("Item is not in list");
    }
    if(list.getItems().isEmpty()){
        toDoListRepository.deleteById(listId);
    }

    }

    // update item
    public void updateItem (ToDoItem item){ toDoItemRepository.save(item);}
    //filter item by priority

    //----------- TODOLIST ----------

    public void saveList (ToDoList list){
        list.setItems(new ArrayList<>());
        toDoListRepository.save(list);}


    //add toDoList
    public void addItemToToDoList(Long toDoListId, ToDoItem newItem){
        ToDoList listToUpdate = toDoListRepository.findById(toDoListId).get();
        listToUpdate.addItemToList(newItem);
        newItem.setToDoList(listToUpdate);
        toDoItemRepository.save(newItem);
        toDoListRepository.save(listToUpdate);

    }
    // find toDoList by Id
    public ToDoListDTO  findListById (Long Id){
        Optional<ToDoList> result = toDoListRepository.findById(Id);
        if (result.isEmpty()){
            return null;
        }
        ToDoList toDoList = result.get();
        ToDoListDTO toDoListDTO = toDoListDTOBuilder(toDoList);
        return toDoListDTO;
    }
    //display toDoList
    public List<ToDoListDTO> findAllLists (){
        List<ToDoList> toDoLists = toDoListRepository.findAll();
        List<ToDoListDTO> toDoListDTOS = new ArrayList<>();
        for(ToDoList toDoList : toDoLists){
            toDoListDTOS.add(toDoListDTOBuilder(toDoList));
        }
        return toDoListDTOS;
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
    public List<ToDoListDTO> getAllCompletedLists(){
        List<ToDoList> completedLists = toDoListRepository.findByItemsIsCompletedTrue();
        List<ToDoListDTO> toDoListDTOS = new ArrayList<>();
        for(ToDoList toDoList : completedLists){
            toDoListDTOS.add(toDoListDTOBuilder(toDoList));
        }
        return toDoListDTOS;
    }
    //update boolean method from false to true
    public ToDoItem updateItemCompletion(Long itemId, boolean isCompleted){
       ToDoItem toDoItem = toDoItemRepository.findById(itemId).get();
       toDoItem.setCompleted(isCompleted);
       return toDoItemRepository.save(toDoItem);
    }

    private ToDoListDTO toDoListDTOBuilder(ToDoList toDoList){
        return new ToDoListDTO(toDoList.getId(), toDoList.getItems(), toDoList.getDate(), toDoList.checkListIsCompleted());
    }



}
