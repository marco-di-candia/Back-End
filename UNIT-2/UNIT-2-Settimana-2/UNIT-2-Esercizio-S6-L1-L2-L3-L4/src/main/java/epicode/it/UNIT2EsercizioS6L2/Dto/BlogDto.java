package epicode.it.UNIT2EsercizioS6L2.Dto;

import lombok.Data;

@Data
public class BlogDto {
	private String categoria;
	private String titolo;
	private String cover;
	private String contenuto;
	private int tempo_di_lettura;

	private int id_autore;
}
