package org.example;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "utente")
public class Utente {
	@Id
	@GeneratedValue
	private int numero_tessera;

	private	String nome;
	private String cognome;
	@Column(name = "data_nascita")
	private LocalDate data_nascita;

	public Utente(String cognome, LocalDate data_nascita, String nome, int numero_tessera) {
		this.cognome = cognome;
		this.data_nascita = data_nascita;
		this.nome = nome;
		this.numero_tessera = numero_tessera;
	}

	public Utente (){}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getData_nascita() {
		return data_nascita;
	}

	public void setData_nascita(LocalDate data_nascita) {
		this.data_nascita = data_nascita;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero_tessera() {
		return numero_tessera;
	}

	public void setNumero_tessera(int numero_tessera) {
		this.numero_tessera = numero_tessera;
	}

	@Override
	public String toString() {
		return "Utente{" +
				"cognome='" + cognome + '\'' +
				", numero_tessera=" + numero_tessera +
				", nome='" + nome + '\'' +
				", data_nascita=" + data_nascita +
				'}';
	}
}
