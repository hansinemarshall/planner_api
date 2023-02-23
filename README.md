# Backend Project (BNTA Week 6)

# List of Collaborators
A 1-week group-based project consisting of the Bright Network Technology Academy Cohort 8 members:

- Hansine Marshall (Github: [hansinemarshall](https://github.com/hansinemarshall))
- Samra Afzaal (Github: [samra-a](https://github.com/samra-a))
- Thinesan Manoseelan (Github: [thinesan29](https://github.com/thinesan29))


# Project Theme
We decided as a group to create a to-do list API for our project as it can be used for day-to-day activities. Past research shows that using a daily to-do list can be very helpful as it can boost a person's productivity and memory, resulting in long-term benefits such as maintaining good mental health.

This API was created using Java. We then used SpringBoot to implement the Spring Framework. Postman and H2 database was used to view our API request endpoints.


# Project Timeline

<img width="895" alt = "Project Timeline" src = "https://i.imgur.com/3cl68Le.png">

~ **Friday (17/02/2023)** 
- Project group was set.
- Started discussing ideas for our project theme.

~ **Monday (20/02/2023)** 
- Our project theme was set.
- Created our UML diagram.
- Created our ER diagram.
- Create our models via Intelli J.
- Created our repository package.
- Created our services package.

~ **Tuesday (21/02/2023)**
- Created our controllers package.
- Used Postman to view our API request endpoints.
- Debugging.

~ **Wednesday (22/02/2023)**
- Implemented a DTO.
- Implemented enums.

~ **Thursday (23/02/2023)**
- Branch merging.
- Started prepartions for presentation.

~ **Friday (23/02/2023)**
- Presentation day.



# The API
- A One-to-Many relationship between ToDoItem and ToDoList.


# Entity Relationship Diagram (ERD)
<img width="895" alt = "ER_Diagram.png" src = "https://i.imgur.com/g7tgmGb.png">

# Class Diagram
<img width="895" alt = "UML_Diagram.png" src = "https://i.imgur.com/x8o3aCn.png">


# Dependencies
- Spring Web
- SpringBoot DevTools
- Spring Data JPA
- H2 Database


# Commands for Postman
## 1. GET (SHOW)

|**GET METHODS**|
|:----------- |
|**GET ToDoListById** : http://localhost:8080/todolists/1|
|**GET AllDoLists** : http://localhost:8080/todolists|

## 2. POST (CREATE)

**POST New ToDoList**:

This will add a new list with the topic type *"add topic type"*:
```
 URL : http://localhost:8080/todolists

{

    "date" :  "insert date here"
    "topic" : "insert topic here"
}
```
**POST New ToDoItem**: 

This will add a new item with the task type *"add task type"*:
```
URL : http://localhost:8080/todolists/1


{

    "task" : "insert task here"
}
```

## 3. PATCH 

**PATCH UpdateItemCompletion**:
```
URL: http://localhost:8080/todolists/1/item/5

{

    true
}
```
**PATCH ChangeItemPriority**:
```
URL : http://localhost:8080/todolists/item/5

{

    enum value (i.e. 0 = LOW, 1 = MEDIUM, 2 = HIGH)
}
```

## 4. DELETE
|**DELETE METHODS**|
|:----------- |
|**DELETE ToDoItem** : http://localhost:8080/todolists/1/item/1|
|**DELETE ToDoList** : http://localhost:8080/todolists/1|


