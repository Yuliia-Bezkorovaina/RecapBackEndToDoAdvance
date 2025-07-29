package org.example.recapbackendtodoadvance.todo;

import java.util.List;

public record ChatGPTResponse(List<ChatGPTChoice> choices) {
}
