package com.StudentLibrary.Studentlibrary.dto;

import com.StudentLibrary.Studentlibrary.Model.Book;
import com.StudentLibrary.Studentlibrary.Model.Genre;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class NewBookRequest {

    private String name;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private int authorId;


    public Book toBook() {
        Book book = new Book();
        book.setName(this.name);
        book.setGenre(this.genre);
        return book;
    }
}
