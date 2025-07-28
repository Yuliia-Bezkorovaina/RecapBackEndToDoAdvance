package org.example.recapbackendtodoadvance.todo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private final TodoService todoService;
    private static final String UUID_REGEX = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";
    private static final Pattern UUID_PATTERN = Pattern.compile(UUID_REGEX);

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
