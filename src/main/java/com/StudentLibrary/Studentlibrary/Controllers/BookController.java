package com.StudentLibrary.Studentlibrary.Controllers;

import com.StudentLibrary.Studentlibrary.Model.Book;
import com.StudentLibrary.Studentlibrary.Services.BookService;
import com.StudentLibrary.Studentlibrary.dto.BookResponse;
import com.StudentLibrary.Studentlibrary.dto.NewBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/createBook")
    public ResponseEntity<BookResponse> createBook(@RequestBody NewBookRequest book){

        BookResponse bookResponse = bookService.createBook(book);
        return new ResponseEntity(bookResponse, HttpStatus.ACCEPTED);

    }
    @GetMapping("/getBooks")
    public ResponseEntity<List<BookResponse>> getBooks(@RequestParam(value = "genre",required = false) String genre,
                                   @RequestParam(value = "available",required = false,defaultValue = "false") boolean available,
                                   @RequestParam(value = "author",required = false) String author){

        List<BookResponse> bookList=bookService.getBooks(genre,available,author);
        return new ResponseEntity(bookList,HttpStatus.OK);




    }




}
