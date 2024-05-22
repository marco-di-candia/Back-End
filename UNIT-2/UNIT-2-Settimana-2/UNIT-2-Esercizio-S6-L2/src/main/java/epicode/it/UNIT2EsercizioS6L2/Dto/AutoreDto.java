package epicode.it.UNIT2EsercizioS6L2.Dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AutoreDto {
	private String nome;
	private String cognome;
	private String email;
	private LocalDate data_nascita;
	private String avatar;

}
