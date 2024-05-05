package org.example;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "prestito")
public class Prestito {
	@Id
	@GeneratedValue
	private int id_prestito;
	@ManyToOne
	@JoinColumn(name = "utente_id")
	private Utente utente;

	@ManyToMany
	@JoinTable(
			name = "Oggetto_Prestato",
			joinColumns = @JoinColumn(name = "prestito_id"),
			inverseJoinColumns = @JoinColumn(name = "elemento_id")
	)
	private List<Libreria> elementiPrestati;
	private LocalDate data_inizio_prestito;
	private LocalDate data_restituzione_prestita;
	private LocalDate data_restituzione_effetiva;


	public Prestito(LocalDate data_restituzione_effetiva, LocalDate data_inizio_prestito, LocalDate data_restituzione_prestita, int id_prestito, Utente utente) {
		this.data_restituzione_effetiva = data_restituzione_effetiva;
		this.data_inizio_prestito = data_inizio_prestito;
		this.data_restituzione_prestita = data_restituzione_prestita;
		this.id_prestito = id_prestito;
		this.utente = utente;
	}
	public Prestito(){}

	public LocalDate getData_inizio_prestito() {
		return data_inizio_prestito;
	}

	public void setData_inizio_prestito(LocalDate data_inizio_prestito) {
		this.data_inizio_prestito = data_inizio_prestito;
	}

	public LocalDate getData_restituzione_effetiva() {
		return data_restituzione_effetiva;
	}

	public void setData_restituzione_effetiva(LocalDate data_restituzione_effetiva) {
		this.data_restituzione_effetiva = data_restituzione_effetiva;
	}

	public LocalDate getData_restituzione_prestita() {
		return data_restituzione_prestita;
	}

	public void setData_restituzione_prestita(LocalDate data_restituzione_prestita) {
		this.data_restituzione_prestita = data_restituzione_prestita;
	}

	public int getId_prestito() {
		return id_prestito;
	}

	public void setId_prestito(int id_prestito) {
		this.id_prestito = id_prestito;
	}


	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	@Override
	public String toString() {
		return "Prestito{" +
				"data_restituzione_effetiva=" + data_restituzione_effetiva +
				", data_inizio_prestito=" + data_inizio_prestito +
				", data_restituzione_prestita=" + data_restituzione_prestita +
				", id_prestito=" + id_prestito +
				", elementiPrestati=" + elementiPrestati +
				", utente=" + utente +
				'}';
	}
}
