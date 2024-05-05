package org.example.dao;

import org.example.Libreria;
import org.example.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LibreriaDao {
	private EntityManager em;

	public LibreriaDao(EntityManager em) {
		this.em = em;
	}

	public void save(Libreria libreria){
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(libreria);
		et.commit();
	}

	public Libreria getById(int id){
		return em.find(Libreria.class,id);
	}

	public void delete(int id){
		EntityTransaction et = em.getTransaction();
		et.begin();
		Libreria libreria = getById(id);

		if(libreria!=null){
			em.remove(libreria);
		}
		else{
			System.out.println("Evento non presente");
		}

		et.commit();

	}
}
