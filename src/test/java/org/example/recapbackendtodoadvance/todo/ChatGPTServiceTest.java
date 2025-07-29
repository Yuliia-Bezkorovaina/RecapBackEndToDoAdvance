package org.example.recapbackendtodoadvance.todo;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureMockRestServiceServer;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureMockRestServiceServer
class ChatGPTServiceTest {
    /*
    @Autowired
    MockMvc mockMvc;

    @Autowired
    MockRestServiceServer mockRestServiceServer;

    @Test
    void test_correct_spelling_german() throws Exception {
        mockRestServiceServer.expect(requestTo("https://api.openai.com/v1/completions"))
                .andExpect(method(HttpMethod.POST))
                .andRespond(withSuccess("""
                            {
                              "choices": [
                                { "text": "Dein Text ist korrekt." }
                              ]
                            }
                        """, MediaType.APPLICATION_JSON));

        mockMvc.perform(MockMvcRequestBuilders.post("/api/todo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                    {
                                      "text": "Ich bin ein Beispielsatz."
                                    }
                                """))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Dein Text ist korrekt."));
    }

    @Test
    void testCheckTextSpellingMistakes() throws Exception {
        mockRestServiceServer.expect(requestTo("https://api.openai.com/v1/completions"))
                .andExpect(method(HttpMethod.POST))
                .andRespond(withSuccess("""
                        {
                                                     "choices": [
                                                         {
                                                             "message": "task"
                                                         }
                                                     ]
                                                 }""", MediaType.APPLICATION_JSON));


       mockRestServiceServer.expect(requestTo("https://api.openai.com/v1/completions"))
                .andExpect(method(HttpMethod.POST))
                .andRespond(withSuccess("""
                        {
                        "message" : "task"
                        }""", MediaType.APPLICATION_JSON));

        mockMvc.perform(MockMvcRequestBuilders.post("/api/todo"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.post("/api/todo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "description": "task"
                                }
                                """))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("task"));

    }

    @Test
    void testCheckTextSpellingMistakes2() throws Exception {
        mockRestServiceServer.expect(requestTo("https://api.openai.com/v1/completions"))
                .andExpect(method(HttpMethod.POST))
                .andRespond(withSuccess("""
                        {
                        "message" : "task"
                        }""", MediaType.APPLICATION_JSON));

        mockMvc.perform(MockMvcRequestBuilders.post("/api/todo"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

*/
}
