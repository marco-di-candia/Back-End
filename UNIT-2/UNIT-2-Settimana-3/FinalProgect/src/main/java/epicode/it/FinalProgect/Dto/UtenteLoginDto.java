package epicode.it.FinalProgect.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UtenteLoginDto {
	@Email
	@NotNull
	private String email;
	@NotNull
	private String password;
}
