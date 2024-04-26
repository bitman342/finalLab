package com.StudentLibrary.Studentlibrary.intergrationunittest;

import com.StudentLibrary.Studentlibrary.Model.Author;
import com.StudentLibrary.Studentlibrary.Repositories.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthorControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void testAuthorCreationAndDeletion() throws Exception {
        String authorJson = "{\"name\":\"John Doe\", \"email\":\"john@example.com\"}";

        mockMvc.perform(post("/createAuthor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(authorJson))
                .andExpect(status().isCreated());

        Author author = authorRepository.findByName("John Doe").get();
        mockMvc.perform(delete("/deleteAuthor?id=" + author.getId()))
                .andExpect(status().isAccepted());
    }
}
