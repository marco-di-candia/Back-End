package epicode.it.UNIT2EsercizioS6L2.model;

import lombok.Data;

@Data
public class Blog {
	private int id;
	private static int count;
	private String categoria;
	private String titolo;
	private String cover;
	private String contenuto;
	private int tempo_di_lettura;

	public Blog(String categoria, String contenuto, String cover, String titolo, int tempo_di_lettura) {
		this.categoria = categoria;
		this.contenuto = contenuto;
		this.cover = "https://picsum.photos/200/300";
		this.titolo = titolo;
		this.tempo_di_lettura = tempo_di_lettura;
		count++;
		id = count;
	}
}
