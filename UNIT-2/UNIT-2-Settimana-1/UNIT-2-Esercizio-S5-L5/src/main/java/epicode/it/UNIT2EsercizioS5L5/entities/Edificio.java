package epicode.it.UNIT2EsercizioS5L5.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Table(name = "edifici")
@Entity
public class Edificio {

	@Id
	@GeneratedValue
	private int id;

	private String nome;
	private String indirizzo;
	private String citta;

	@OneToMany(mappedBy = "edificio")
	private List<Postazione> postaziones;


}
