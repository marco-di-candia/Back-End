package epicode.it.UNIT2EsercizioS5L5.services;
import epicode.it.UNIT2EsercizioS5L5.entities.Utente;
import epicode.it.UNIT2EsercizioS5L5.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UtenteService {

	@Autowired
	UtenteRepository utenteRepository;

	public List<Utente> getAll() {return utenteRepository.findAll();}

	public Utente getById(Integer id) {return utenteRepository.findById(id).orElseThrow(null);}

	public Utente save(Utente utente) {return utenteRepository.save(utente);}

	public void findByIdAndDelete(Integer id) {utenteRepository.deleteById(id);}
}
