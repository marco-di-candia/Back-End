package org.example;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Libreria implements Interface {
	@Id
	@GeneratedValue
	private int codiceIsbn;
	private String titolo;
	private int anno;
	private int numeroPagine;
	@ManyToMany(mappedBy = "elementiPrestati")
	private List<Prestito> prestiti;


	public Libreria(int anno, int codiceIsbn, int numeroPagine, String titolo) {
		this.anno = anno;
		this.codiceIsbn = codiceIsbn;
		this.numeroPagine = numeroPagine;
		this.titolo = titolo;
	}

	public Libreria() {

	}


	public int getAnno() {
		return anno;
	}

	public int getCodiceIsbn() {
		return codiceIsbn;
	}

	public int getNumeroPagine() {
		return numeroPagine;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}

	@Override
	public String toString() {
		return "Libreria{" + "anno=" + anno + ", codiceIsbn=" + codiceIsbn + ", titolo='" + titolo + '\'' + ", numeroPagine=" + numeroPagine + '}';
	}

	@Override
	public String getAutore() {
		return "";
	}

	@Override
	public String getGenere() {
		return "";
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public void setCodiceIsbn(int codiceIsbn) {
		this.codiceIsbn = codiceIsbn;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
}
