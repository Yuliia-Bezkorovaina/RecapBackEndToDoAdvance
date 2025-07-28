package org.example.recapbackendtodoadvance.todo;

public record UpdateTodo(
        String description,
        TodoStatus status
) {
}
