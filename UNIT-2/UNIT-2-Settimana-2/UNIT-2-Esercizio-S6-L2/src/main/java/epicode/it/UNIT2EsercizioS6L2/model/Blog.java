package epicode.it.UNIT2EsercizioS6L2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "blog")
public class Blog {
	@Id
	@GeneratedValue
	private int id;
	private String categoria;
	private String titolo;
	private String cover;
	private String contenuto;
	private int tempo_di_lettura;

	@ManyToOne
	@JoinColumn(name = "autore_id")
	@JsonIgnore
	private Autore autore;

}
