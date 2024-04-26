package com.StudentLibrary.Studentlibrary.dto;

import com.StudentLibrary.Studentlibrary.Model.Author;
import lombok.Data;


@Data
public class NewAuthor {

    private int id;

    private String name;

    private String email;

    private int age;
    private String country;

    public NewAuthor(String johnDoe, String mail) {
    }

    public Author toAuthor(){
        Author author=new Author();
        author.setId(this.id);
        author.setName(this.name);
        author.setEmail(this.email);
        author.setAge(this.age);
        author.setCountry(this.country);
        return author;
    }
}
