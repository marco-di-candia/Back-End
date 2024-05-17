package epicode.it.UNIT2EsercizioS5L5.repositories;


import epicode.it.UNIT2EsercizioS5L5.entities.Postazione;
import epicode.it.UNIT2EsercizioS5L5.enums.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione,Integer> {

	List<Postazione> findByTipoPostazioneAndEdificioCitta(TipoPostazione tipoPostazione, String citta);


}
