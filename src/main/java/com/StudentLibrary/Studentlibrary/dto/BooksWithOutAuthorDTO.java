//package com.StudentLibrary.Studentlibrary.dto;
//
//import com.StudentLibrary.Studentlibrary.Model.Author;
//import com.StudentLibrary.Studentlibrary.Model.Book;
//import com.StudentLibrary.Studentlibrary.Model.Card;
//import com.StudentLibrary.Studentlibrary.Model.Genre;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.Data;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Data
//public class BooksWithOutAuthorDTO {
//    private int id;
//
//    private String name;
//
//    private Genre genre;
//
//    Author author;
//
//
//    Card card;
//
//
//    public static List<BooksWithOutAuthorDTO> fromBooks(List<Book> books){
//       return books.stream().map(BooksWithOutAuthorDTO::fromBooks).collect(Collectors.toList());
//    }
//    public static BooksWithOutAuthorDTO fromBooks(Book book){
//        BooksWithOutAuthorDTO booksWithOutAuthorDTO=new BooksWithOutAuthorDTO();
//        booksWithOutAuthorDTO.setId(book.getId());
//        booksWithOutAuthorDTO.setName(book.getName());
//        booksWithOutAuthorDTO.setGenre(book.getGenre());
//        booksWithOutAuthorDTO.setAuthor(book.getAuthor());
//        booksWithOutAuthorDTO.setCard(book.getCard());
//        return booksWithOutAuthorDTO;
//    }
//}
