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
public class AuthorControllerIntegrationTestw {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void testAuthorCreationAndUpdateAndDeletion() throws Exception {
        // Create an author
        String authorJson = "{\"name\":\"John Doe\", \"email\":\"john@example.com\"}";
        mockMvc.perform(post("/createAuthor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(authorJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.email").value("john@example.com"));

        // Retrieve the author to update
        Author author = authorRepository.findByName("John Doe").get();

        // Update the author
        String updatedAuthorJson = "{\"name\":\"Jane Doe\", \"email\":\"jane@example.com\"}";
        mockMvc.perform(put("/updateAuthor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedAuthorJson)
                        .param("id", String.valueOf(author.getId())))
                .andExpect(status().isAccepted());

        // Verify the update
        mockMvc.perform(get("/getAuthor?id=" + author.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Jane Doe"))
                .andExpect(jsonPath("$.email").value("jane@example.com"));

        // Delete the author
        mockMvc.perform(delete("/deleteAuthor?id=" + author.getId()))
                .andExpect(status().isAccepted());
    }
}
