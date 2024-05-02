package dao;

import antity.Evento;
import antity.Location;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDao {
	private EntityManager em;

	public LocationDao(EntityManager em){
		this.em = em;
	}
	public void save(Location location){
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(location);
		et.commit();
	}
	public Location getId(int id){
		Location e =em.find(Location.class,id);
		return e;
	}

	public void delete(Location location){
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(location);
		et.commit();
	}
}
