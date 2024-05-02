package antity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "partecipazioni")
public class Partecipazioni {
	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	@JoinColumn(name = "persona_id")
	private Persona persona;

	@ManyToOne
	@JoinColumn(name = "evento_id")
	private Evento evento;

	@Enumerated(EnumType.STRING)
	private Stato stato;

	public Partecipazioni(Evento evento, int id, Persona persona, Stato  stato) {
		this.evento = evento;
		this.id = id;
		this.persona = persona;
		this.stato = stato;
	}
	public Partecipazioni(){}

	public Evento getEvento() {
		return (Evento) evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Stato  getStato() {
		return stato;
	}

	public void setStato(Stato stato) {
		this.stato = stato;
	}
}
