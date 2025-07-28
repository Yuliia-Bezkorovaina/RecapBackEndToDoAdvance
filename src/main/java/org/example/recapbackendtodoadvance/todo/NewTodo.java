package org.example.recapbackendtodoadvance.todo;

public record NewTodo(
        String description,
        TodoStatus status
) {
}
