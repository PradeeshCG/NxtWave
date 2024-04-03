Setup a new Spring Project and connect to a database (file/memory/cloud  based) and create a TODOLIST table with the following schema and populate with the initial data. 

### TODOLIST Table

| Columns | Type |
| --- | --- |
| id | INTEGER |
| todo | TEXT |
| status | TEXT |
| priority | TEXT |

> Possible values for `priority` are `HIGH`, `MEDIUM`, and `LOW`.
> 
> 
> Possible values for `status` are `TO DO`, `IN PROGRESS`, and `DONE`.
> 

### Completion Instructions

Follow the Spring project folder structure and create the controllers, services, models and repositories etc. 

- `Todo.java`: `Todo` class should contain the following attributes.
    
    
    | Attribute | Type |
    | --- | --- |
    | id | int |
    | todo | String |
    | status | String |
    | priority | String |
- `TodoRepository.java`: Create an `interface` containing the required methods.
- `TodoJpaService.java`: Update the service class with logic for managing todo data.
- `TodoController.java`: Create the controller class to handle HTTP requests.
- `TodoJpaRepository.java`: Create an interface that extends the `JpaRpository` Interface.

Implement the following APIs.

### API 1

### Path: `/todos`

### Method: `GET`

### Description:

Returns a list of all `todos` in the `todoList`.

### Sample Response

```
[
    {
        "id": 1,
        "todo": "Watch Movie",
        "priority": "LOW",
        "status": "TO DO"
    },
   ...
]

```

### API 2

### Path: `/todos`

### Method: `POST`

### Description:

Creates a new todo in the `todoList`. The `id` is auto-incremented.

### Request

```
{
    "todo": "Read Book",
    "priority": "MEDIUM",
    "status": "TO DO"
}

```

### Sample Response

```
{
    "id": 6,
    "todo": "Read Book",
    "priority": "MEDIUM",
    "status": "TO DO"
}

```

### API 3

### Path: `/todos/{id}`

### Method: `GET`

### Description:

Returns todo based on the `id`. If the given `id` is not found in the `todoList`, raise `ResponseStatusException` with `HttpStatus.NOT_FOUND`.

### Success Response

```
{
    "id": 3,
    "todo": "Buy Groceries",
    "priority": "MEDIUM",
    "status": "TO DO"
}

```

### API 4

### Path: `/todos/{id}`

### Method: `PUT`

### Description:

Updates the details of todo in the `todoList` based on the `id`. If the given `id` is not found in the `todoList`, raise `ResponseStatusException` with `HttpStatus.NOT_FOUND`.

### Request

```
{
    "status": "DONE"
}

```

### Sample Success Response

```
{
    "id": 3,
    "todo": "Buy Groceries",
    "priority": "MEDIUM",
    "status": "DONE"
}

```

### API 5

### Path: `/todos/{id}`

### Method: `DELETE`

### Description:

Deletes todo from the `todoList`  based on the `id`. If the given `id` is not found in the `todoList`, raise `ResponseStatusException` with `HttpStatus.NOT_FOUND`.
