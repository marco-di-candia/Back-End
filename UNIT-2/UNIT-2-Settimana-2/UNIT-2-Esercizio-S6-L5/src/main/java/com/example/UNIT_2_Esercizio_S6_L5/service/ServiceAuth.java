package com.example.UNIT_2_Esercizio_S6_L5.service;

import com.example.UNIT_2_Esercizio_S6_L5.DTO.DtoDipendenteLogin;
import com.example.UNIT_2_Esercizio_S6_L5.exception.UnauthorizedException;
import com.example.UNIT_2_Esercizio_S6_L5.model.Dipendente;
import com.example.UNIT_2_Esercizio_S6_L5.security.JwtTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceAuth {
	@Autowired
	private ServiceDipendente serviceDipendente;
	@Autowired
	private JwtTool jwtTool;

	public String authenticateUserAndCreateToken(DtoDipendenteLogin dipendenteLogin){
		Dipendente user = serviceDipendente.getUserByEmail(dipendenteLogin.getEmail());

		if(user.getPassword().equals(dipendenteLogin.getPassword())){
			return jwtTool.createToken(user);
		}
		else{
			throw new UnauthorizedException("Error in authorization, relogin!");
		}
	}
}
