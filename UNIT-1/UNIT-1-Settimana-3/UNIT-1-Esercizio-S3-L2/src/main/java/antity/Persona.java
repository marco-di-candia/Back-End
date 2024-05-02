package antity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "persona")
public class Persona {
	@Id
	@GeneratedValue
	private int id;
	@Column(nullable = false)

	private String nome;
	@Column(nullable = false)

	private String cognome;
	@Column(nullable = false)

	private String email;
	@Column(name = "data_nascita")

	private LocalDate data_nascita;

	@Enumerated(EnumType.STRING)
	private TipoPersona sesso;

	@OneToMany(mappedBy = "persona")
	private List<Partecipazioni> partecipazioni;

	public Persona(String cognome, LocalDate data_nascita, String email, int id, String nome, TipoPersona sesso) {
		this.cognome = cognome;
		this.data_nascita = data_nascita;
		this.email = email;
		this.id = id;
		this.nome = nome;
		this.sesso = sesso;
	}
	public Persona(){}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getData_nascita() {
		return data_nascita;
	}

	public void setData_nascita(LocalDate data_nascita) {
		this.data_nascita = data_nascita;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoPersona getSesso() {
		return sesso;
	}

	public void setSesso(TipoPersona sesso) {
		this.sesso = sesso;
	}

	@Override
	public String toString() {
		return "Persona{" +
				"cognome='" + cognome + '\'' +
				", id=" + id +
				", nome='" + nome + '\'' +
				", email='" + email + '\'' +
				", data_nascita=" + data_nascita +
				", sesso=" + sesso +
				'}';
	}
}
