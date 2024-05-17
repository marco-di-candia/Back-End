package epicode.it.UNIT2EsercizioS5L5.repositories;


import epicode.it.UNIT2EsercizioS5L5.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione,Integer> {

	List<Prenotazione> findByPostazioneId(Integer idPostazione);
	List<Prenotazione> findByUtenteId(Integer idUtente);
	List<Prenotazione> findByPostazioneIdAndData(Integer idPostazione, LocalDate dataPrenotazione);



}
