package epicode.it.UNIT2EsercizioS6L2.service;


import epicode.it.UNIT2EsercizioS6L2.Dto.AutoreDto;
import epicode.it.UNIT2EsercizioS6L2.exception.AutoreNonTrovatoException;
import epicode.it.UNIT2EsercizioS6L2.model.Autore;
import epicode.it.UNIT2EsercizioS6L2.repository.AutoreRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AutoreService {
	@Autowired
	private AutoreRepository autoreRepository;

	public String save(AutoreDto autoreDto) {
		Autore autore = new Autore();
		autore.setNome(autoreDto.getNome());
		autore.setCognome(autoreDto.getCognome());
		autore.setEmail(autoreDto.getEmail());
		autore.setData_nascita(autoreDto.getData_nascita());

		autoreRepository.save(autore);
		return "autore con id=" + autore.getId() + " creata con successo";
	}

	public List<Autore> getAll() {
		return autoreRepository.findAll();
	}

	public Optional<Autore> getById(int id) {
		return autoreRepository.findById(id);
	}
	@SneakyThrows
	public Autore update(int id, AutoreDto autoreDto)  {
		Optional<Autore> aulaOptional = getById(id);

		if (aulaOptional.isPresent()) {
			Autore autore = aulaOptional.get();
			autore.setNome(autoreDto.getNome());
			autore.setCognome(autoreDto.getCognome());
			autore.setEmail(autoreDto.getEmail());
			autore.setData_nascita(autoreDto.getData_nascita());

			return autoreRepository.save(autore);
		} else {
			throw new AutoreNonTrovatoException("autore con id=" + id + " non trovato");
		}
	}
	@SneakyThrows
	public String delete(int id) {
		Optional<Autore> autoreOptional = getById(id);

		if (autoreOptional.isPresent()) {
			autoreRepository.delete(autoreOptional.get());
			return "Aula con id=" + id + " cancellata con successo";
		} else {
			throw new AutoreNonTrovatoException("Aula con id=" + id + " non trovata");
		}
	}


}
