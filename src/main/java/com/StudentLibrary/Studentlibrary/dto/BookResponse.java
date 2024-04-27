package com.StudentLibrary.Studentlibrary.dto;

import com.StudentLibrary.Studentlibrary.Model.Book;
import com.StudentLibrary.Studentlibrary.Model.Genre;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class BookResponse {
    private long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Genre genre;
    public static BookResponse fromBook(Book book) {
        BookResponse bookResponse = new BookResponse();
        bookResponse.setId(book.getId());
        bookResponse.setName(book.getName());
        bookResponse.setGenre(book.getGenre());
        return bookResponse;
    }
}
