package com.StudentLibrary.Studentlibrary.dto.auth;

import com.StudentLibrary.Studentlibrary.Model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private String accessToken;
    private String refreshToken;
    private User.RoleType role;
    private String email;
    private String firstName;
    private String lastName;
}
