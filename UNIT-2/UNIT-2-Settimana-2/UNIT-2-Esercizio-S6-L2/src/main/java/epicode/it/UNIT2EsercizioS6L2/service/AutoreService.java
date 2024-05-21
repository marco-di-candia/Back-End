package epicode.it.UNIT2EsercizioS6L2.service;

import epicode.it.UNIT2EsercizioS6L2.exception.AutoreNonTrovatoException;
import epicode.it.UNIT2EsercizioS6L2.model.Autore;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AutoreService {
	private List<Autore> Autores = new ArrayList<>();

	public List<Autore> getAll() {
		return Autores;
	}

	public String save(Autore Autore) {
		Autores.add(Autore);
		return "autore Creato" + " " + Autore.getId();
	}

	public Optional<Autore> getById(int id) {
		return Autores.stream().filter(blog -> blog.getId() == id).findFirst();
	}

	public Autore update(int id, Autore autore) throws AutoreNonTrovatoException {
		Optional<Autore> autoreOpt = getById(id);
		if (autoreOpt.isPresent()) {
			Autore autore1 = autoreOpt.get();
			autore1.setNome(autore.getNome());
			autore1.setCognome(autore.getCognome());
			autore1.setEmail(autore.getEmail());
			autore1.setData_nascita(autore.getData_nascita());
			return autore1;
		} else {
			throw new AutoreNonTrovatoException("autore non trovato");
		}
	}

	public String delete(int id) throws AutoreNonTrovatoException {
		Optional<Autore> blogOpt = getById(id);

		if (blogOpt.isPresent()) {
			Autores.remove(blogOpt.get());
			return "autore cancellato";
		} else {
			throw new AutoreNonTrovatoException("autore non trovato");
		}
	}

}
