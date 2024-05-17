package epicode.it.UNIT2EsercizioS5L5.services;
import epicode.it.UNIT2EsercizioS5L5.entities.Postazione;
import epicode.it.UNIT2EsercizioS5L5.enums.TipoPostazione;
import epicode.it.UNIT2EsercizioS5L5.repositories.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostazioneService {

	@Autowired
	PostazioneRepository postazioneRepository;

	public List<Postazione> findByTipoPostazioneAndEdificioCitta(TipoPostazione tipoPostazione, String citta) {
		return postazioneRepository.findByTipoPostazioneAndEdificioCitta(tipoPostazione, citta);
	}

	public List<Postazione> getAll() {return postazioneRepository.findAll();}

	public Postazione getById(Integer id) {return postazioneRepository.findById(id).orElseThrow(null);}

	public Postazione save(Postazione postazione) {return postazioneRepository.save(postazione);}

	public void findByIdAndDelete(Integer id) {postazioneRepository.deleteById(id);}
}
