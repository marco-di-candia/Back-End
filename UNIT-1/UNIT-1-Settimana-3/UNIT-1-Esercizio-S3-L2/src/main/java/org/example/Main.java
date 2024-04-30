package org.example;

import antity.Evento;
import antity.TipoEvento;
import dao.EventoDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("S3-L2");
		EntityManager em = emf.createEntityManager();

		EventoDao dao = new EventoDao(em);

		Evento e = new Evento();
		e.setTitolo("progectX");
		e.setDataEvento(LocalDate.of(2024, 5, 1));
		e.setDescrizione("white party");
		e.setTipoEvento(TipoEvento.valueOf("PUBBLICO"));
		e.setNumeroMaxPartecipanti(500);

		dao.save(e);

		Evento e1 = dao.getId(1);
		System.out.println(e1);
		e1.setTipoEvento(TipoEvento.valueOf("PRIVATO"));

		dao.save(e1);

		dao.delete(e1);


	}
}