package com.StudentLibrary.Studentlibrary.Services;

import com.StudentLibrary.Studentlibrary.dto.auth.LoginRequest;
import com.StudentLibrary.Studentlibrary.dto.auth.LoginResponse;
import com.StudentLibrary.Studentlibrary.dto.auth.RefreshTokenRequest;
import com.StudentLibrary.Studentlibrary.dto.auth.RefreshTokenResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);

    RefreshTokenResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
