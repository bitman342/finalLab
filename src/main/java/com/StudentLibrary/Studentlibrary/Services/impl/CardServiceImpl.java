package com.StudentLibrary.Studentlibrary.Services.impl;


import com.StudentLibrary.Studentlibrary.Model.Card;
import com.StudentLibrary.Studentlibrary.Model.Student;
import com.StudentLibrary.Studentlibrary.Repositories.CardRepository;
import com.StudentLibrary.Studentlibrary.Repositories.StudentRepository;
import com.StudentLibrary.Studentlibrary.dto.CreateCardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardServiceImpl {


    private final StudentRepository studentRepository;
    private final CardRepository cardRepository;

    public CreateCardResponse createCard(String username) {

     Student student =  studentRepository.findByEmail(username).orElseThrow(() -> new RuntimeException("Student not found"));

     if(student.getCard() != null){
         throw new RuntimeException("Card already exists");
     }

     Card card = new Card();
     cardRepository.save(card);

        student.setCard(card);
        studentRepository.save(student);

        return  CreateCardResponse.fromCard(card);


    }
}
