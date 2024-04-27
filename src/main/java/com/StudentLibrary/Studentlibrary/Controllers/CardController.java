package com.StudentLibrary.Studentlibrary.Controllers;


import com.StudentLibrary.Studentlibrary.Services.impl.CardServiceImpl;
import com.StudentLibrary.Studentlibrary.dto.CreateCardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CardController {


    private final CardServiceImpl cardService;


    @PostMapping("/createCard")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCardResponse createCard(Authentication authentication){

        System.out.println("Authentication: " + authentication.getPrincipal() );
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();



        return cardService.createCard(userDetails.getUsername());



    }
}
