package org.example.recapbackendtodoadvance.todo;

import java.time.ZonedDateTime;

public record ErrorMessage(ZonedDateTime createdAt,
                           String message) {
}
