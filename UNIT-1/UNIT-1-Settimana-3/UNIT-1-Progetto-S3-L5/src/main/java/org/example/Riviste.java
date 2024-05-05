package org.example;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "riviste")
public class Riviste extends Libreria {
	@Enumerated(EnumType.STRING)
	private Periodicita periodicita;

	public Riviste(int anno, int codiceIsbn, int numeroPagine, String titolo, Periodicita periodicita) {
		super(anno, codiceIsbn, numeroPagine, titolo);
		this.periodicita = periodicita;
	}

	public Riviste(){}


	public Periodicita getPeriodicita() {

		return periodicita;
	}

	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}

	@Override
	public String toString() {
		return "Libreria{" +
				"anno=" + getAnno() +
				", codiceIsbn=" + getCodiceIsbn() +
				", titolo='" + getTitolo() + '\'' +
				", numeroPagine=" + getNumeroPagine() +
				"periodicita='" + periodicita + '\'' +
				'}';
	}

}
