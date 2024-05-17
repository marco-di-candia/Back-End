package epicode.it.UNIT2EsercizioS5L5.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Table(name = "prenotazioni")
@Entity
public class Prenotazione {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer  id;
	@Column(name = "data_prenotazione")
	private LocalDate data;

	@ManyToOne
	@JoinColumn(name = "utente_id")
	private Utente utente;

	@ManyToOne
	@JoinColumn(name = "postazione_id")
	private Postazione postazione;

}
