package org.example;

import antity.*;
import dao.EventoDao;
import dao.LocationDao;
import dao.PartecipazioniDao;
import dao.PersonaDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("S3-L2");
		EntityManager em = emf.createEntityManager();

		EventoDao dao = new EventoDao(em);
		PersonaDao daoPerson = new PersonaDao(em);
		PartecipazioniDao daoParteci = new PartecipazioniDao(em);
		LocationDao daoLacation = new LocationDao(em);

		//creo l'evento
		Evento e1 = new Evento();
		e1.setTipoEvento(TipoEvento.PUBBLICO);
		e1.setTitolo("Concerto 1 maggio");
		e1.setDescrizione("Concerto al Circo Massimo");
		e1.setDataEvento(LocalDate.of(2024,5,1));

		//salvo l'evento sul db
		dao.save(e1);

		//creo la location
		Location location = new Location();
		location.setNome("Circo Massimo");
		location.setCitta("Roma");
		//salvo la location sul db
		daoLacation.save(location);

		//aggancio la location all'evento
		e1.setLocation(location);
		//risalvo l'evento
		dao.save(e1);

		//creo una persona
		Persona p1 = new Persona();
		p1.setNome("Dario");
		p1.setCognome("Sellitti");
		p1.setEmail("dfasljk");
		p1.setSesso(TipoPersona.M);
		//salvo la persona
		daoPerson.save(p1);

		//creo un'altra persona
		Persona p2 = new Persona();
		p2.setNome("Mario");
		p2.setCognome("Stanco");
		p2.setEmail("dfasljk");
		p2.setSesso(TipoPersona.M);
		//salvo la persona sul db
		daoPerson.save(p2);

		//creo una partecipazione passandogli la persona e l'evento
		Partecipazioni p4 = new Partecipazioni();
		p4.setEvento(e1);
		p4.setPersona(p1);
		p4.setStato(Stato.CONFERMATA);

		//salvo la partecipazione
		daoParteci.save(p4);

		//creo un'altra partecipazione passandogli la persona e l'evento
		Partecipazioni p5 = new Partecipazioni();
		p5.setEvento(e1);
		p5.setPersona(p2);
		p5.setStato(Stato.CONFERMATA);

		//salvo la seconda partecipazione
		daoParteci.save(p5);












	}
}