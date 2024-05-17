package epicode.it.UNIT2EsercizioS5L5.services;
import epicode.it.UNIT2EsercizioS5L5.entities.Prenotazione;
import epicode.it.UNIT2EsercizioS5L5.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service

public class PrenotazioneService {

	@Autowired
	PrenotazioneRepository prenotazioneRepository;

	public List<Prenotazione> findByPostazioneId(Integer idPostazione) {
		return prenotazioneRepository.findByPostazioneId(idPostazione);
	}

	public List<Prenotazione> findByUtenteId(Integer idUtente) {
		return prenotazioneRepository.findByUtenteId(idUtente);
	}

	public List<Prenotazione> findByPostazioneIdAndData(Integer idPostazione, LocalDate dataPrenotazione) {
		return prenotazioneRepository.findByPostazioneIdAndData(idPostazione, dataPrenotazione);
	}

	public List<Prenotazione> getAll() {return prenotazioneRepository.findAll();}

	public Prenotazione getById(Integer id) {return prenotazioneRepository.findById(id).orElseThrow(null);}

	public Prenotazione save(Prenotazione prenotazione) {return prenotazioneRepository.save(prenotazione);}

	public void findByIdAndDelete(Integer id) {prenotazioneRepository.deleteById(id);}
}
