//package com.StudentLibrary.Studentlibrary.dto;
//
//import com.StudentLibrary.Studentlibrary.Model.Author;
//import com.StudentLibrary.Studentlibrary.Model.Book;
//import com.StudentLibrary.Studentlibrary.Model.Card;
//import com.StudentLibrary.Studentlibrary.Model.Genre;
//import lombok.Data;
//
//import java.util.List;
//import java.util.stream.Collectors;
//@Data
//public class BookWithAuthorDto {
//    private int id;
//
//    private String name;
//
//    private Genre genre;
//
//    private Author author;
//
//    private Card card;
//
//    public static List<BookWithAuthorDto> fromBooks(List<Book> books) {
//        return books.stream().map(BookWithAuthorDto::fromBook).collect(Collectors.toList());
//    }
//
//    public static BookWithAuthorDto fromBook(Book book) {
//        BookWithAuthorDto bookWithAuthorDto = new BookWithAuthorDto();
//        bookWithAuthorDto.setId(book.getId());
//        bookWithAuthorDto.setName(book.getName());
//        bookWithAuthorDto.setGenre(book.getGenre());
//        bookWithAuthorDto.setAuthor(book.getAuthor());
//        bookWithAuthorDto.setCard(book.getCard());
//        return bookWithAuthorDto;
//    }
//
//}