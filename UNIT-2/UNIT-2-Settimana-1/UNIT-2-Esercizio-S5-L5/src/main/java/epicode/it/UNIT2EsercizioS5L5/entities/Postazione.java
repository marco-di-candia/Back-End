package epicode.it.UNIT2EsercizioS5L5.entities;

import epicode.it.UNIT2EsercizioS5L5.enums.TipoPostazione;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Table(name = "postazioni")
@Entity
public class Postazione {

	@Id
	@GeneratedValue
	private int id;

	private String descrizione;

	@Enumerated
	@Column(name = "tipo_postazione")
	private TipoPostazione tipoPostazione;

	private int numMaxOccupanti;

	@ManyToOne
	@JoinColumn(name = "edificio_id")
	private Edificio edificio;

}
