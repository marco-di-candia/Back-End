package epicode.it.UNIT2EsercizioS5L5.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Table(name = "utenti")
@Entity
public class Utente {

	@Id
	@GeneratedValue
	private int id;

	private String username;
	private String nome;
	private String email;

	@OneToMany(mappedBy = "utente")
	private List<Prenotazione> prenotazioni;

}
