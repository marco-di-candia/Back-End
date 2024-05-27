package com.example.UNIT_2_Esercizio_S6_L5.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DtoDipendenteLogin {

	@NotBlank
	@Email(message = "L'email non può essere vuota o mancante o composta da soli spazi")
	private String email;

	@NotBlank(message = "La password non può essere vuota o mancante o composta da soli spazi")
	private String password;
}
