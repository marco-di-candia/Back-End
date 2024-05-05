package org.example.dao;

import org.example.Libreria;
import org.example.Prestito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class PrestitoDao {
	private EntityManager em;

	public PrestitoDao(EntityManager em) {
		this.em = em;
	}

	public void save(Prestito prestito){
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(prestito);
		et.commit();
	}

	public Prestito getById(int id){
		return em.find(Prestito.class,id);
	}

	public void delete(int id){
		EntityTransaction et = em.getTransaction();
		et.begin();
		Prestito prestito = getById(id);

		if(prestito!=null){
			em.remove(prestito);
		}
		else{
			System.out.println("Evento non presente");
		}

		et.commit();

	}
	public List<Prestito> getPrestitiAttiviPerUtente(int numero_tessera) {
		Query query = em.createQuery("SELECT p FROM Prestito p WHERE p.utente.numero_tessera = :numero_tessera");
		query.setParameter("numero_tessera", numero_tessera);
		return query.getResultList();
	}

	public List<Prestito> getPrestitiScadutiNonRestituiti() {
		Query query = em.createQuery("SELECT p FROM Prestito p WHERE p.data_restituzione_prestita < CURRENT_DATE");
		return query.getResultList();
	}
}
