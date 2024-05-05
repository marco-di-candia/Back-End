package org.example.dao;

import org.example.Libri;
import org.example.Riviste;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class RivisteDao {
	private EntityManager em;

	public RivisteDao(EntityManager em) {
		this.em = em;
	}

	public void save(Riviste riviste){
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(riviste);
		et.commit();
	}

	public Riviste getById(int id){
		return em.find(Riviste.class,id);
	}

	public void delete(int id){
		EntityTransaction et = em.getTransaction();
		et.begin();
		Riviste riviste = getById(id);

		if(riviste!=null){
			em.remove(riviste);
		}
		else{
			System.out.println("Evento non presente");
		}

		et.commit();

	}
}
