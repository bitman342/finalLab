package com.StudentLibrary.Studentlibrary.Services;

import com.StudentLibrary.Studentlibrary.Model.Author;
import com.StudentLibrary.Studentlibrary.Repositories.AuthorRepository;
import com.StudentLibrary.Studentlibrary.Services.utill.JWTUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class AuthorService {

    AuthorRepository authorRepository;
    PasswordEncoder passwordEncoder;
    JWTUtil jwtUtil;


//    public Author createAuthor(Author author){
//        return authorRepository.save(author);
//
//    }
public Author createAuthor(com.StudentLibrary.Studentlibrary.dto.NewAuthor newAuthor){
    Author author = newAuthor.toAuthor();
    return authorRepository.save(author);
}
    public void updateAuthor(Author author){
        authorRepository.updateAuthorDetails(author);
    }
    public void deleteAuthor(int id ){
        authorRepository.deleteCustom(id);
    }
}
