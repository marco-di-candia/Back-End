package epicode.it.FinalProgect.Dto;

import epicode.it.FinalProgect.enums.RuoloUtente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UtenteDto {
	@NotNull
	private String nome;
	@NotNull
	private String cognome;
	@Email
	@NotNull
	private String email;
	@NotNull
	private String password;

	private RuoloUtente ruoloUtente;
}