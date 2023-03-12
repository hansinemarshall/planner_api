# To-do List API Backend Group Project

## Project Theme
We, as a group, have decided to create a to-do list API for our project, as it can be used for day-to-day activities. Past research has shown that using a daily to-do list can be very helpful, as it can boost a person's productivity and memory, resulting in long-term benefits, such as maintaining good mental health.

<hr />

## API Description
The API provides endpoints for managing a user's daily tasks and events. It allows the user to create, read, update, and delete tasks and events, as well as manage the priorities of each task.

### ToDoLists:
This represents a to-do list that contains multiple to-do items. It has a topic and a date.

### ToDoItems:
Represents a to-do item that belongs to a to-do list. It contains a task, a status (completed or not), and a priority level.

### ToDoListDTO:
The Data Transfer Object class represents a to-do list. It contains the same information as the ToDoList class but is used for transferring data between layers of the application.

### Priority:
An enum class that defines the priority levels that a to-do item can have:
- `LOW`
- `MEDIUM`
- `HIGH`

### Topic:
Represents a topic that a to-do item can be associated with. The following is a list of all available topic enum values:<br>
- `BUCKET_LIST`
- `SHOPPING_LIST` 
- `GIFT_IDEAS`
- `TO_WATCH_LIST`
- `THINGS_NOT_TO_FORGET` 

<hr />

## Relationships
The API uses a one-to-many relationship between ToDoLists and ToDoItems, where each ToDoList can have multiple ToDoItems. This means that a single ToDoList can have multiple related ToDoItems, but each ToDoItem can only belong to one ToDoList. The relationship is established through the use of foreign keys.

<hr />

## Class Diagrams

### UML Diagram
The relationships and attributes of each model are displayed in the UML diagram (shown below).

<img width="895" alt = "UML_Diagram.png" src = "https://i.imgur.com/x8o3aCn.png">

### Entity Relationship Diagram (ERD)
The entity relationship diagram (shown below) illustrates the relationship between each model.

<img width="895" alt = "ER_Diagram.png" src = "https://i.imgur.com/g7tgmGb.png">

<hr />

## Tech Stack
- Intellij IDEA (JDK 17)
- PostgreSQL 
- Spring Boot
- Postico
- Postman

<hr />

## Setup Instructions

1. Ensure the following are installed on your machine: 
- Intellij IDEA , running with JDK 17
- Postgres
- Postman
- Postico

2. Clone the repository from GitHub. Scroll to the top of this page and click on the green Code button. Ensure SSH is selected and copy the link provided. In your terminal, perform the following command:<br> 
`git clone git@github.com:hansinemarshall/planner_api.git`

3. Create a new PostgreSQL database named 'planner' anywhere in your terminal.<br>
`create db planner`

4. Via Intellij IDEA, run the `PlannerApiApplication` and make sure the API is running on port 8080.

5. Via Postman, create a new collection called ToDoList and add requests using the 'Postman Instructions' provided below.

<hr /> 

## Postman Instructions

### 1. GET (SHOW)

**1.1 GET AllDoLists** <br>
``````
Method: GET 
Endpoint : /todolists
URL: http://localhost:8080/todolists
```````

This GET request retrieves all the to-do lists available in the API.

**1.2 GET ToDoListById** <br>
``````
Method: GET 
Endpoint : /todolists/1
URL: http://localhost:8080/todolists/1
```````

This GET method retrieves a single ToDoList resource by its unique identifier (Id) specified in the URL path parameter. In this case, the Id is 1. The method returns the ToDoList object with all its associated ToDoItems, if any, and related information such as the priority,topic and date.

<hr />

### 2. POST (CREATE)

**2.1 POST New ToDoList**:<br>
``````
Method: POST 
Endpoint : /todolists
URL: http://localhost:8080/todolists
```````

The request body must be a JSON object containing the date and topic enum values. The topic enum values are all listed in the API description section. If the request is successful, it will respond with a status code of 201 (Created) and the newly created ToDoList object in the response body.

**NOTE - When a new (empty) list is created, it shows up as `completed=true` , until items are added to it.**

In Postman, select Body -> JSON -> raw  and enter the following for the request body: 
```````
{
   "date" :  "2023-12-03",
   "topic" : "GIFT_IDEAS"
}
```````

In this example, the topic enum value is "GIFT_IDEAS". If you want to use other examples, please refer to the listed topic enum values in the API description. Anything not on the list will NOT work.

**2.2 POST New ToDoItem**: 
``````
Method: POST 
Endpoint : /todolists/1
URL: http://localhost:8080/todolists/1
```````

This method is used to create a new ToDoItem within a specific ToDoList. The "1" is the id of the ToDoList that the new ToDoItem will be added to.Once the request is made, the server will create a new ToDoItem object with the provided information and add it to the specified ToDoList. If the creation is successful, it will respond with a status code of 201 (Created) and the newly created ToDoItem in the response body.

In Postman, select Body -> JSON -> raw  and enter the following for the request body:

``````
{
    "task" : "Buy Dairy-Milk Chocolate"
}
``````

<hr />

### 3. PATCH (UPDATE)

**3.1 PATCH UpdateItemCompletion**:

``````
Method: PATCH 
Endpoint : /todolists/1/item/5
URL: http://localhost:8080/todolists/1/item/5
```````
This method is used to update the completion status of a ToDoItem. "1"  is the id of the ToDoList and "5" is the id of the specific ToDoItem being updated. The request body should contain a boolean value indicating the new completion status.If the value is true, it means the ToDoItem is completed, and if the value is false, it means the ToDoItem is not completed. 

In Postman, select Body -> JSON -> raw  and enter the following for the request body:

```````
true
```````

**NOTE: No curly brackets are required in the request body.** 

**3.2 PATCH ChangeItemPriority**:
``````
Method: PATCH 
Endpoint : /todolists/item/5
URL: http://localhost:8080/todolists/item/5
```````
This method updates the priority of a specific to-do item in a to-do list based on the given item Id in the URL. The request body takes an enum value that corresponds to the priority level (LOW, MEDIUM, or HIGH), where 0 represents LOW, 1 represents MEDIUM, and 2 represents HIGH.

In Postman, select Body -> JSON -> raw  and enter the following for the request body:

````
1
````

In this example, the priority level is changed to MEDIUM. <br> 
Put in 0 to change  priority level to LOW.<br>
Put in 2 to change  priority level to HIGH.<br>

**NOTE: No curly brackets are required in the request body.** 

<hr />

### 4. DELETE

**4.1 DELETE ToDoItem**
``````
Method: DELETE
Endpoint : /todolists/1/item/1
URL: http://localhost:8080/todolists/1/item/1
```````

This method removes a specific ToDoItem from the ToDoList with the Id of 1. This method can be used to delete completed or unnecessary items from the ToDoList.The response body is empty, and the response status code is 204 No Content, indicating that the request has been successfully processed.

**4.2 DELETE ToDoList**
``````
Method: DELETE
Endpoint : /todolists/1
URL: http://localhost:8080/todolists/1
```````
This method allows the deletion of a specific ToDoList by using its Id in the URL. "1" is the Id of the ToDoList to be deleted.The response body is empty, and the response status code is 204 No Content, indicating that the request has been successfully processed.

**NOTE: When the last item in a list is deleted,the list itself is also deleted.** 

<hr />

## Dependencies
- Spring Data JPA
- Spring Web
- SpringBoot Devtools

<hr />

## Collaborators

- Hansine Marshall (Github: [hansinemarshall](https://github.com/hansinemarshall))
- Samra Afzaal (Github: [samra-a](https://github.com/samra-a))
- Thinesan Manoseelan (Github: [thinesan29](https://github.com/thinesan29))


