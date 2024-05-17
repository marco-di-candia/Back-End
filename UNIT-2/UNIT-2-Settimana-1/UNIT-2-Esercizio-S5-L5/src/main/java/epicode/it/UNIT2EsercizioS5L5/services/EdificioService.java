package epicode.it.UNIT2EsercizioS5L5.services;
import epicode.it.UNIT2EsercizioS5L5.entities.Edificio;
import epicode.it.UNIT2EsercizioS5L5.repositories.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EdificioService {

	@Autowired
	EdificioRepository edificioRepository;

	public List<Edificio> getAll() {return edificioRepository.findAll();}

	public Edificio getById(Integer id) {return edificioRepository.findById(id).orElseThrow(null);}

	public Edificio save(Edificio edificio) {return edificioRepository.save(edificio);}

	public void findByIdAndDelete(Integer id) {edificioRepository.deleteById(id);}

}
