package epicode.it.UNIT2EsercizioS5L5;

import epicode.it.UNIT2EsercizioS5L5.entities.Edificio;
import epicode.it.UNIT2EsercizioS5L5.entities.Postazione;
import epicode.it.UNIT2EsercizioS5L5.entities.Prenotazione;
import epicode.it.UNIT2EsercizioS5L5.entities.Utente;
import epicode.it.UNIT2EsercizioS5L5.enums.TipoPostazione;
import epicode.it.UNIT2EsercizioS5L5.services.EdificioService;
import epicode.it.UNIT2EsercizioS5L5.services.PostazioneService;
import epicode.it.UNIT2EsercizioS5L5.services.PrenotazioneService;
import epicode.it.UNIT2EsercizioS5L5.services.UtenteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	EdificioService edificioService;
	@Autowired
	PostazioneService postazioneService;
	@Autowired
	PrenotazioneService prenotazioneService;
	@Autowired
	UtenteService utenteService;

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		Edificio e1 = new Edificio();
		e1.setNome("Rooftop Ceresio 7");
		e1.setCitta("Milano");
		e1.setIndirizzo("Via Ceresio, 7, 20154 Milano MI");
		edificioService.save(e1);

		Utente u1 = new Utente();
		u1.setNome("Mario Rossi");
		u1.setUsername("mariomario1");
		u1.setEmail("mariorossi@gmail.com");
		utenteService.save(u1);

		Postazione pos1 = new Postazione();
		pos1.setDescrizione("Ristorante panoramico con terrazza e piscine che serve cocktail e piatti di cucina italiana contemporanea.");
		pos1.setEdificio(e1);
		pos1.setTipoPostazione(TipoPostazione.OPENSPACE);
		pos1.setNumMaxOccupanti(150);
		postazioneService.save(pos1);

		Prenotazione pre1 = new Prenotazione();
		pre1.setUtente(u1);
		pre1.setData(LocalDate.of(2024,05,19));
		pre1.setPostazione(pos1);
		prenotazioneService.save(pre1);

		List<Postazione> postazioni = postazioneService.findByTipoPostazioneAndEdificioCitta(TipoPostazione.OPENSPACE, "Milano");
		System.out.println(postazioni);

		List<Prenotazione> prenotazioniByPostazioneId = prenotazioneService.findByPostazioneId(1);
		System.out.println(prenotazioniByPostazioneId);

		List<Prenotazione> prenotazioniByUtenteId = prenotazioneService.findByUtenteId(1);
		System.out.println(prenotazioniByUtenteId);

		List<Prenotazione> prenotazioniByPostazioneIdAndData = prenotazioneService.findByPostazioneIdAndData(1, pre1.getData());
		System.out.println(prenotazioniByPostazioneIdAndData);
	}

}
