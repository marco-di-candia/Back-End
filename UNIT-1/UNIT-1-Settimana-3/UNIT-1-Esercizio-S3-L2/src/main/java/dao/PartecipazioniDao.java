package dao;
import antity.Partecipazioni;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipazioniDao {
	private EntityManager em;

	public PartecipazioniDao(EntityManager em){
		this.em = em;
	}
	public void save(Partecipazioni partecipazioni){
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(partecipazioni);
		et.commit();
	}
	public Partecipazioni getId(int id){
		Partecipazioni e = 	em.find(Partecipazioni.class,id);
		return e;
	}

	public void delete(Partecipazioni partecipazioni){
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(partecipazioni);
		et.commit();
	}
}
