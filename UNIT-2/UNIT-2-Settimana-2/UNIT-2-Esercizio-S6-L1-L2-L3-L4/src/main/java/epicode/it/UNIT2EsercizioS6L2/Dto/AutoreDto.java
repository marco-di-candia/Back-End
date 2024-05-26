package epicode.it.UNIT2EsercizioS6L2.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AutoreDto {
	@Size(max = 30, min = 1)
	@NotBlank
	private String nome;
	@NotBlank
	@Size(max = 30 , min = 1)
	private String cognome;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	private LocalDate data_nascita;
	@NotBlank
	private String avatar;

}
