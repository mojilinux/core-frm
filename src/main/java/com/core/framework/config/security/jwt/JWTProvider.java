package com.core.framework.config.security.jwt;

import com.core.framework.domain.user.UserPrincipal;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTProvider {

	@Value("${app.jwtSecret}}")
	private String jwtSecret;

	@Value("${app.jwtExpirationInMin}")
	private int jwtExpirationInMin;

	public String generateToken(Authentication authentication) {
		UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + jwtExpirationInMin * 60000);

		return Jwts.builder().setSubject(userPrincipal.getUsername()).setIssuedAt(new Date()).setExpiration(expiryDate).signWith(SignatureAlgorithm.HS256, jwtSecret).compact();
	}

	public String getUserUsernameFromJWT(String token) {
		Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
		return claims.getSubject();
	}

	public boolean validateToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		}
		catch (MalformedJwtException ex) {
		}
		catch (ExpiredJwtException ex) {
		}
		catch (UnsupportedJwtException ex) {
		}
		catch (IllegalArgumentException ex) {
		}
		return false;
	}
}
