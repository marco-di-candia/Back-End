package org.example;

import java.util.HashSet;
import java.util.Set;

public class Riviste extends Libreria {

	private String periodicita;

	public Riviste(int anno, int codiceIsbn, int numeroPagine, String titolo, String periodicita) {
		super(anno, codiceIsbn, numeroPagine, titolo);
		this.periodicita = periodicita;
	}

	public String getPeriodicita() {
		return periodicita;
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
