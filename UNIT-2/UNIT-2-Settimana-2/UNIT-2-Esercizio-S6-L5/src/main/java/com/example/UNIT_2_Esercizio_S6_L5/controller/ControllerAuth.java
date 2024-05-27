package com.example.UNIT_2_Esercizio_S6_L5.controller;

import com.example.UNIT_2_Esercizio_S6_L5.DTO.DtoDipendente;
import com.example.UNIT_2_Esercizio_S6_L5.DTO.DtoDipendenteLogin;
import com.example.UNIT_2_Esercizio_S6_L5.exception.BadRequestException;
import com.example.UNIT_2_Esercizio_S6_L5.service.ServiceAuth;
import com.example.UNIT_2_Esercizio_S6_L5.service.ServiceDipendente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAuth {
	@Autowired
	private ServiceAuth serviceAuth;

	@Autowired
	private ServiceDipendente dipendente;

	@PostMapping("/auth/register")
	public String register(@RequestBody @Validated DtoDipendente dtoDipendente, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new BadRequestException(bindingResult.getAllErrors().stream().map(error -> error.getDefaultMessage()).
					reduce("", (s, s2) -> s + s2));
		}

		return dipendente.save(dtoDipendente);
	}

	@PostMapping("/auth/login")
	public String login(@RequestBody @Validated DtoDipendenteLogin userLoginDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new BadRequestException(bindingResult.getAllErrors().stream().map(error -> error.getDefaultMessage()).reduce("", (s, s2) -> s + s2));
		}

		return serviceAuth.authenticateUserAndCreateToken(userLoginDto);
	}
}
