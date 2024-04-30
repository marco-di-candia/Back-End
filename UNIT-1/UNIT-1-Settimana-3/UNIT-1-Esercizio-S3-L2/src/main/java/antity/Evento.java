package antity;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "evento")
public class Evento {
	@Id
	@GeneratedValue
	private int id;
	@Column(nullable = false,length = 30)
	private String titolo;
	@Column(name="data_locale")
	private LocalDate dataEvento;
	@Column(nullable = false,length = 30)
	private String descrizione;
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_evento")
	private TipoEvento tipoEvento;
	@Column(nullable = false)
	private int numeroMaxPartecipanti;

	public Evento(LocalDate dataEvento, String descrizione, int id, int numeroMaxPartecipanti, TipoEvento tipoEvento, String titolo) {
		this.dataEvento = dataEvento;
		this.descrizione = descrizione;
		this.id = id;
		this.numeroMaxPartecipanti = numeroMaxPartecipanti;
		this.tipoEvento = tipoEvento;
		this.titolo = titolo;
	}

	public Evento() {}

	public LocalDate getDataEvento() {
		return dataEvento;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public int getId() {
		return id;
	}

	public int getNumeroMaxPartecipanti() {
		return numeroMaxPartecipanti;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setDataEvento(LocalDate dataEvento) {
		this.dataEvento = dataEvento;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNumeroMaxPartecipanti(int numeroMaxPartecipanti) {
		this.numeroMaxPartecipanti = numeroMaxPartecipanti;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	@Override
	public String toString() {
		return "Evento{" + "dataEvento=" + dataEvento + ", id=" + id + ", titolo='" + titolo + '\'' + ", descrizione='" + descrizione + '\'' + ", tipoEvento=" + tipoEvento + ", numeroMaxPartecipanti=" + numeroMaxPartecipanti + '}';
	}
}
