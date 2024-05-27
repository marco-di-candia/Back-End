package com.example.UNIT_2_Esercizio_S6_L5.security;


import com.example.UNIT_2_Esercizio_S6_L5.exception.UnauthorizedException;
import com.example.UNIT_2_Esercizio_S6_L5.model.Dipendente;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTool {

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.duration}")
	private long durata;

	// crea il token impostando data di inizio, data di fine, id dell'dipendente e firma del token attraverso la chiave segreta
	public String createToken(Dipendente dipendente) {
		return Jwts.builder().issuedAt(new Date(System.currentTimeMillis())).
				expiration(new Date(System.currentTimeMillis() + durata)).
				subject(String.valueOf(dipendente.getUsername())).
				signWith(Keys.hmacShaKeyFor(secret.getBytes())).
				compact();
	}
	//effettua la verifica del token ricevuto. Verifica la veridicità del token e la sua scadenza
	public void verifyToken(String token){
		try {
			Jwts.parser().verifyWith(Keys.hmacShaKeyFor(secret.getBytes())).
					build().parse(token);
		}
		catch (Exception e){
			throw  new UnauthorizedException("Error in authorization, relogin!");
		}
	}
}
