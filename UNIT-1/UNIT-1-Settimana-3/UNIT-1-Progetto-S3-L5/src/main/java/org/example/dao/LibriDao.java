package org.example.dao;

import org.example.Libreria;
import org.example.Libri;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class LibriDao {
	private EntityManager em;

	public LibriDao(EntityManager em) {
		this.em = em;
	}

	public void save(Libri libri){
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(libri);
		et.commit();
	}

	public Libri getById(int id){
		return em.find(Libri.class,id);
	}

	public void delete(int id){
		EntityTransaction et = em.getTransaction();
		et.begin();
		Libri libri = getById(id);

		if(libri!=null){
			em.remove(libri);
		}
		else{
			System.out.println("Evento non presente");
		}

		et.commit();


	}
	public List<Libri> searchByIsbn(int codiceIsbn) {
		Query query = em.createQuery("SELECT l FROM Libri l WHERE l.codiceIsbn = :codiceIsbn");
		query.setParameter("codiceIsbn", codiceIsbn);
		return query.getResultList();
	}

	public List<Libri> searchByAnno(int anno) {
		Query query = em.createQuery("SELECT l FROM Libri l WHERE l.anno = :anno");
		query.setParameter("anno", anno);
		return query.getResultList();
	}

	public List<Libri> searchByAutore(String autore) {
		Query query = em.createQuery("SELECT l FROM Libri l WHERE l.autore = :autore");
		query.setParameter("autore", autore);
		return query.getResultList();
	}

	public List<Libri> searchByTitolo(String titolo) {
		Query query = em.createQuery("SELECT l FROM Libri l WHERE l.titolo LIKE :titolo");
		query.setParameter("titolo", "%" + titolo + "%");
		return query.getResultList();
	}

}
