package com.StudentLibrary.Studentlibrary.Services.utill;

import com.StudentLibrary.Studentlibrary.Model.User;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component()
public class JWTUtil {
    static SecretKey key = Jwts.SIG.HS256.key().build();

    private static final long ACCESS_TOKEN_EXPIRATION = 1000 * 60 * 60 * 24;
    private static final long REFRESH_TOKEN_EXPIRATION = ACCESS_TOKEN_EXPIRATION * 30;


    public String extractUsername(String token) {
        return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().getSubject();
    }

    public boolean validateAccessToken(String token, UserDetails userDetails) throws JwtException {

        String userName = extractUsername(token);
        if (!userDetails.getUsername().equals(userName)) {
            throw new JwtException("Invalid token");
        }


        Boolean access = Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().get("access", Boolean.class);

        if (access == null || !access) {
            throw new JwtException("Invalid token");
        }

        return true;
    }

    public boolean validateRefreshToken(String token, UserDetails userDetails) throws JwtException {

        String userName = extractUsername(token);
        if (!userDetails.getUsername().equals(userName)) {
            throw new JwtException("Invalid token");
        }

        Boolean refresh = Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().get("refresh", Boolean.class);

        if (refresh == null || !refresh) {
            throw new JwtException("Invalid token");
        }

        return true;
    }


    public String generateAccessToken(User user) {

        System.out.println("Generating access token");
        System.out.println(user.getEmail());
        return Jwts.builder().subject(user.getEmail()).signWith(key)
                .claim("role", user.getRole().toString())
                .claim("access", true)
                .expiration(Date.from(Instant.now().plus(ACCESS_TOKEN_EXPIRATION, ChronoUnit.MILLIS))).compact();
    }

    public String generateRefreshToken(User user) {


        return Jwts.builder().subject(user.getEmail()).signWith(key)
                .claim("refresh", true)
                .claim("role", user.getRole().toString())
                .expiration(Date.from(Instant.now().plus(REFRESH_TOKEN_EXPIRATION, ChronoUnit.MILLIS))).compact();
    }
}
