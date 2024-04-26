//package com.StudentLibrary.Studentlibrary.dto;
//
//import com.StudentLibrary.Studentlibrary.Model.Author;
//import com.StudentLibrary.Studentlibrary.Model.Book;
//import lombok.Data;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Data
//public class AuthorWithBookDTO {
//
//    private int id;
//
//    private String name;
//
//    private String email;
//
//    private int age;
//    private String country;
//
//    private List<BooksWithOutAuthorDTO> books_written; // Updated field declaration
//
//    public static List<BooksWithOutAuthorDTO> fromBooks(List<Book> books) {
//        return books.stream().map(BooksWithOutAuthorDTO::fromBooks).collect(Collectors.toList());
//    }
//
//    public static AuthorWithBookDTO fromAuthor(Author author) {
//        AuthorWithBookDTO authorWithBookDTO = new AuthorWithBookDTO();
//        authorWithBookDTO.setId(author.getId());
//        authorWithBookDTO.setName(author.getName());
//        authorWithBookDTO.setEmail(author.getEmail());
//        authorWithBookDTO.setAge(author.getAge());
//        authorWithBookDTO.setCountry(author.getCountry());
//        authorWithBookDTO.setBooks_written(convertToBooksWithOutAuthorDTO(author.getBooks_written()));
//        return authorWithBookDTO;
//    }
//
//    private static List<BooksWithOutAuthorDTO> convertToBooksWithOutAuthorDTO(List<Book> books) {
//        List<BooksWithOutAuthorDTO> booksWithoutAuthorDTOList = new ArrayList<>();
//        for (Book book : books) {
//            BooksWithOutAuthorDTO bookWithoutAuthorDTO = new BooksWithOutAuthorDTO();
//            // Populate bookWithoutAuthorDTO fields here from book object
//            booksWithoutAuthorDTOList.add(bookWithoutAuthorDTO);
//        }
//        return booksWithoutAuthorDTOList;
//    }
//}
