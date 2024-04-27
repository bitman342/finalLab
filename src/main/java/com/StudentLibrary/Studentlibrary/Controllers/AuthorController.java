package com.StudentLibrary.Studentlibrary.Controllers;

import com.StudentLibrary.Studentlibrary.Model.Author;
import com.StudentLibrary.Studentlibrary.Services.AuthorService;
import com.StudentLibrary.Studentlibrary.dto.AuthorResponse;
import com.StudentLibrary.Studentlibrary.dto.NewAuthor;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AuthorController {

    @Autowired
    AuthorService authorService;




//    @PostMapping("/createAuthor")
//    public ResponseEntity<Author> createAuthor(@RequestBody Author author){
//      Author createAuthor =  authorService.createAuthor(author);
//        return new ResponseEntity(createAuthor, HttpStatus.CREATED);
//    }
@PostMapping("/createAuthor")
public ResponseEntity<AuthorResponse> createAuthor(@RequestBody NewAuthor newAuthor){

    AuthorResponse createdAuthor =  authorService.createAuthor(newAuthor);
   // Author createdAuthor = authorService.createAuthor(newAuthor);
    return new ResponseEntity<>(createdAuthor, HttpStatus.CREATED);
}

    @PutMapping("/updateAuthor")
    public ResponseEntity updateAuthor(@RequestBody Author author){
        authorService.updateAuthor(author);
        return new ResponseEntity("Auhtor upadted!!",HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/deleteAuthor")
    public ResponseEntity deleteAuthor(@RequestParam("id") int id){
        authorService.deleteAuthor(id);
        return new ResponseEntity("Author deleted!!",HttpStatus.ACCEPTED);

    }

}
