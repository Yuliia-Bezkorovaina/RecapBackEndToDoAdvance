package org.example.recapbackendtodoadvance.todo;

public record Todo(
        String id,
        String description,
        TodoStatus status
) {
}
