package org.example.recapbackendtodoadvance.todo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private final TodoService todoService;


    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.findAllTodos();
    }

    @GetMapping("{id}")
    public Todo getTodoById(@PathVariable String id) {
       return todoService.findTodoById(id);
    }

    @PostMapping
    public Todo postTodo(@RequestBody NewTodo newTodo) {

        if(newTodo.description() == null || newTodo.description().isEmpty() || newTodo.status() == null) {
            throw new IllegalArgumentException("description or status is null or empty");
        }
        return todoService.addTodo(newTodo);
    }

    @PutMapping("{id}")
    public Todo putTodo(@RequestBody UpdateTodo todo, @PathVariable String id) {
        return todoService.updateTodo(todo, id);
    }

    @DeleteMapping("{id}")
    public void deleteTodo(@PathVariable String id) {
        todoService.deleteTodo(id);
    }

    @ExceptionHandler(ResponseStatusException.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ErrorMessage handleResponseStatusExceptionNoContent(ResponseStatusException e) {
        return new ErrorMessage(ZonedDateTime.now(),e.getMessage());
    }

}
