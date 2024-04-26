package com.StudentLibrary.Studentlibrary.Services.impl;

import com.StudentLibrary.Studentlibrary.Model.Student;
import com.StudentLibrary.Studentlibrary.Repositories.StudentRepository;
import com.StudentLibrary.Studentlibrary.Services.AuthService;
import com.StudentLibrary.Studentlibrary.Services.UserDetailsImpl;
import com.StudentLibrary.Studentlibrary.Services.utill.JWTUtil;
import com.StudentLibrary.Studentlibrary.dto.auth.LoginRequest;
import com.StudentLibrary.Studentlibrary.dto.auth.LoginResponse;
import com.StudentLibrary.Studentlibrary.dto.auth.RefreshTokenRequest;
import com.StudentLibrary.Studentlibrary.dto.auth.RefreshTokenResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    final private StudentRepository studentRepository;
    final private PasswordEncoder passwordEncoder;
    final private JWTUtil jwtUtil;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Student student = studentRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        if (passwordEncoder.matches(loginRequest.getPassword(), student.getPassword())) {
            String accessToken = jwtUtil.generateAccessToken(student);
            String refreshToken = jwtUtil.generateRefreshToken(student);
            return new LoginResponse(
                    accessToken,
                    refreshToken,     // String
                    student.getRole(), // User.RoleType
                    student.getEmail(), // String
                    student.getFirstName(), // String
                    student.getLastName()  // String
            );
        }
        throw new RuntimeException("Invalid password");
    }



    @Override
    public RefreshTokenResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        String email = jwtUtil.extractUsername(refreshTokenRequest.getRefreshToken());
        Student student = studentRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Student not found"));
        if (jwtUtil.validateRefreshToken(refreshTokenRequest.getRefreshToken(), new UserDetailsImpl(student))) {
            String accessToken = jwtUtil.generateAccessToken(student);
            return new RefreshTokenResponse(accessToken, refreshTokenRequest.getRefreshToken());
        }
        throw new RuntimeException("Invalid token");
    }


}
