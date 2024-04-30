package dao;

import antity.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventoDao {
private EntityManager em;

	public EventoDao(EntityManager em){
	this.em = em;
	}
	public void save(Evento evento){
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(evento);
		et.commit();
	}
public Evento getId(int id){
		Evento e = 	em.find(Evento.class,id);
		return e;
	}

	public void delete(Evento evento){
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(evento);
		et.commit();
	}
}
