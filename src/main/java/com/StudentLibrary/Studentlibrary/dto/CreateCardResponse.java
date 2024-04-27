package com.StudentLibrary.Studentlibrary.dto;

import com.StudentLibrary.Studentlibrary.Model.Card;
import lombok.Data;


@Data
public class CreateCardResponse {

    private int id;

    public static CreateCardResponse fromCard(Card card) {
        CreateCardResponse createCardResponse = new CreateCardResponse();
        createCardResponse.setId(card.getId());
        return createCardResponse;
    }
}
