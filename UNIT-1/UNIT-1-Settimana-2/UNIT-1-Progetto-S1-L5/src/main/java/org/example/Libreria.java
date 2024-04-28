package org.example;

public class Libreria implements Interface {
	private int codiceIsbn;
	private String titolo;
	private int anno;
	private int numeroPagine;

	public Libreria(int anno, int codiceIsbn, int numeroPagine, String titolo) {
		this.anno = anno;
		this.codiceIsbn = codiceIsbn;
		this.numeroPagine = numeroPagine;
		this.titolo = titolo;
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


}
