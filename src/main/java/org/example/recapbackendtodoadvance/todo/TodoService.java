package org.example.recapbackendtodoadvance.todo;


import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final IdService idService;
    private final ChatGPTService chatGPTService;


    public TodoService(TodoRepository todoRepository, IdService idService, ChatGPTService chatGPTService) {
        this.todoRepository = todoRepository;
        this.idService = idService;
        this.chatGPTService = chatGPTService;
    }

    public List<Todo> findAllTodos() {
        return todoRepository.findAll();
    }

    public Todo addTodo(NewTodo newTodo) {
        String id = idService.randomId();

        String description = chatGPTService.checkTextSpellingMistakes(newTodo.description());

        Todo todoToSave = new Todo(id, description, newTodo.status());

        return todoRepository.save(todoToSave);
    }

    public Todo updateTodo(UpdateTodo todo, String id) {

        String description = chatGPTService.checkTextSpellingMistakes(todo.description());
        Todo todoToUpdate = new Todo(id, description, todo.status());

        return todoRepository.save(todoToUpdate);
    }

    public Todo findTodoById(String id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Todo with id: " + id + " not found!"));
    }

    public void deleteTodo(String id) {

        todoRepository.deleteById(id);
    }
}
