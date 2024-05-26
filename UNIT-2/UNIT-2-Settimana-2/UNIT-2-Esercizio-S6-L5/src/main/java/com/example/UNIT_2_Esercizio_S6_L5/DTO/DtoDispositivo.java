package com.example.UNIT_2_Esercizio_S6_L5.DTO;

import com.example.UNIT_2_Esercizio_S6_L5.enums.TipoDispositivo;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DtoDispositivo {
	@NotBlank
	private String dispositivo;
	@NotBlank
	private TipoDispositivo statoDispositivo;

	private int dipendenteId;


}
