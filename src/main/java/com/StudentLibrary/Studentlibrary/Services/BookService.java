package com.StudentLibrary.Studentlibrary.Services;

import com.StudentLibrary.Studentlibrary.Model.Book;
import com.StudentLibrary.Studentlibrary.Repositories.BookRepository;
import com.StudentLibrary.Studentlibrary.dto.BookResponse;
import com.StudentLibrary.Studentlibrary.dto.NewBookRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {


    BookRepository bookRepository;

    public BookResponse createBook(NewBookRequest bookRequest){

        Book book = bookRequest.toBook();

        book =   bookRepository.save(book);

       return BookResponse.fromBook(book);

    }
    //Either giving you all the available books
    //OR gicing you all the non-available books
    public List<BookResponse> getBooks(String genre, boolean isAvailable, String author){

        if (genre!=null&&author!=null){
            return bookRepository.findBooksByGenre_Author(genre,author,isAvailable).stream().map(BookResponse::fromBook).toList() ;
        }
        else if (genre!=null){
            return bookRepository.findBooksByGenre(genre,isAvailable).stream().map(BookResponse::fromBook).toList() ;
        }
        else if (author!=null){
            return bookRepository.findBooksByAuthor(author,isAvailable).stream().map(BookResponse::fromBook).toList() ;
        }
        return bookRepository.findBooksByAvailability(isAvailable).stream().map(BookResponse::fromBook).toList() ;







    }

}
