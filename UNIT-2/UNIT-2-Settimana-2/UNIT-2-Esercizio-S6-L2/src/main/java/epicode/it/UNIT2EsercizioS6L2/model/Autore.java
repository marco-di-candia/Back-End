package epicode.it.UNIT2EsercizioS6L2.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Autore {
	private int id;
	private static int count;
	private String nome;
	private String cognome;
	private String email;
	private LocalDate data_nascita;
	private String avatar;

	public Autore(String avatar, String cognome, LocalDate data_nascita, String email, String nome) {
		this.cognome = cognome;
		this.data_nascita = data_nascita;
		this.email = email;
		this.nome = nome;
		count++;
		id = count;
		this.avatar = "https://ui-avatars.com/api/?name=" + nome + "+" + cognome;
	}
}
