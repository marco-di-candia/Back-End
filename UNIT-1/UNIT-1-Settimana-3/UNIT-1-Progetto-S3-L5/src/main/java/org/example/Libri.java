package org.example;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "libri")
public class Libri extends Libreria implements Interface {
	private String autore;
	private String genere;

	public Libri(int anno, int codiceIsbn, int numeroPagine, String titolo, String autore, String genere) {
		super(anno, codiceIsbn, numeroPagine, titolo);
		this.autore = autore;
		this.genere = genere;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public Libri(){}

	public String getAutore() {
		return autore;
	}

	public String getGenere() {
		return genere;
	}


	@Override
	public String toString() {
		return "Libreria{" + "anno=" + getAnno() + ", codiceIsbn=" + getCodiceIsbn() + ", titolo='" + getTitolo() + '\'' + ", numeroPagine=" + getNumeroPagine() + "autore='" + autore + '\'' + ", genere='" + genere + '\'' + '}';
	}
}
