package epicode.it.UNIT2EsercizioS6L2.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "autore")
public class Autore {
	@Id
	@GeneratedValue
	private int id;
	private String nome;
	private String cognome;
	private String email;
	private LocalDate data_nascita;
	private String avatar;

	@OneToMany(mappedBy = "autore")
	private List<Blog> blogs;

}
