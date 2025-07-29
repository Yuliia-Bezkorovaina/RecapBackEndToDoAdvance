package org.example.recapbackendtodoadvance.todo;

import java.util.List;

public record ChatGPTRequest(String model,
                             List<ChatGPTMessages> messages
                            ) {}
