package com.ss.util;

import com.ss.model.AuthToken;
import com.ss.model.JwtUserDetails;
import com.ss.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    @Value("${jwt.private-key}")
    private String signedKey;

    public AuthToken generateToken(User user) {
        Claims claims = Jwts.claims().setSubject(user.getUserId());
        claims.setIssuedAt(new Date(System.currentTimeMillis()));
        claims.setExpiration(new Date(System.currentTimeMillis() + (300 * 1000)));
        claims.put("userName", user.getUserName());
        claims.put("role", "customer");
        return AuthToken
                .builder()
                .token(Jwts.builder()
                        .setClaims(claims)
                        .signWith(SignatureAlgorithm.HS512, signedKey)
                        .compact())
                .build();
    }

    public JwtUserDetails validateToken(String authToken) {
        try {
            Claims claims = Jwts.parser().setSigningKey(signedKey).parseClaimsJws(authToken).getBody();
            Date expireTime = claims.getExpiration();

            if (expireTime.before(new Date(System.currentTimeMillis()))) {
                throw new RuntimeException("token is expired");
            }

            return JwtUserDetails
                    .builder()
                    .userName((String) claims.get("userName"))
                    .roles((String) claims.get("role"))
                    .userId(claims.getSubject())
                    .build();

        } catch (Exception ex) {
            throw new RuntimeException("token is not valid");
        }
    }
}
