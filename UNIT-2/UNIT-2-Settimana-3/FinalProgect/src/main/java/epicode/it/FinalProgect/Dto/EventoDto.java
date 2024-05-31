package epicode.it.FinalProgect.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EventoDto {
	@NotNull
	private String titolo;
	@NotNull
	private String descrizione;
	@NotNull
	private LocalDate data;
	@NotNull
	private String luogo;
	@NotNull
	private Integer numPostiDisponibili;
}