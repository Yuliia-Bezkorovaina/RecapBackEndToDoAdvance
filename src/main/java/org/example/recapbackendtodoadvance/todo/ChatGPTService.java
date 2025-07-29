package org.example.recapbackendtodoadvance.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class ChatGPTService {

    private final RestClient restClient;

    public ChatGPTService(RestClient.Builder restClientBuilder,
                            @Value("${API_KEY}") String apikey) {
        this.restClient = restClientBuilder
                .baseUrl("https://api.openai.com/v1/chat/completions")
                .defaultHeader("Authorization", "Bearer " + apikey)
                .build();
    }

    public String checkTextSpellingMistakes(String description) {

        String prompt = "I want you to act as a proofreader and editor for a **Todo description**. " +
                "My goal is to receive a corrected text free of any grammatical, spelling, punctuation, " +
                "syntax, or stylistic errors. The corrected text should be concise and clearly convey the task. " +
                "Please analyze the provided Todo description and return its corrected version. " +
                "Do not add any explanations, comments, or additional information. " +
                "Return only the corrected text itself.Here is the Todo description to review: " + description;

        ChatGPTMessages message = new ChatGPTMessages("user", prompt);
        ChatGPTRequest request = new ChatGPTRequest(
                "gpt-4.1",
                List.of(message)
        );

        ChatGPTResponse response = restClient
                .post()
                .body(request)
                .retrieve()
                .body(ChatGPTResponse.class);

        return response.choices().get(0).message().content().trim().toLowerCase();
    }


}
