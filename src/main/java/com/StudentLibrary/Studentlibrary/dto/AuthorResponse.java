package com.StudentLibrary.Studentlibrary.dto;


import com.StudentLibrary.Studentlibrary.Model.Author;
import lombok.Data;

@Data
public class AuthorResponse {


    private Long id;

    private String name;

    private String email;

    private int age;
    private String country;

    public static AuthorResponse fromAuthor(Author author) {
        AuthorResponse authorResponse = new AuthorResponse();
        authorResponse.setId(author.getId());
        authorResponse.setName(author.getName());

        authorResponse.setEmail(author.getEmail());
        authorResponse.setAge(author.getAge());
        authorResponse.setCountry(author.getCountry());
        return authorResponse;
    }
}
