package business;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import project.Allarme;
import project.Terapia;
import project.Utente;
import utility.JPAutility;

public class AllarmeManager {
private static Logger log = Logger.getLogger("app-rendere");
	
	public static void aggiungiUtente(Allarme a) {
		EntityManager em = JPAutility.getEm();
		
		Allarme aDb = em.find(Allarme.class, a.getId());
		if (aDb == null) {
			em.getTransaction().begin();
			em.persist(a); 
			em.getTransaction().commit();
			log.log(Level.INFO, "Aggiunto allarme");
		} else {
			log.log(Level.WARNING, "Allarme esiste già");
		}
	}
	
	
	public static void modificaAllarme(Allarme a ) {
		EntityManager em = JPAutility.getEm();
		Allarme aDb = em.find(Allarme.class, a.getEmail());
		if (aDb != null) {
			em.getTransaction().begin();
			aDb.setAllarme(a.getAllarme());
			em.getTransaction().commit();
			log.log(Level.INFO, "Allarme modificato");

}
	}

	public void rimuoviAllarme(Allarme a) {
		EntityManager em = JPAutility.getEm();
		Allarme aDb = em.find(Allarme.class, a.getId());
		if (aDb != null) {
		em.getTransaction().begin();
	    em.remove(a);
		em.getTransaction().commit();
		log.log(Level.INFO, "Allarme rimosso");
	}
}
	
	
	public static List<Allarme> elencoAllarmi() {
		EntityManager em = JPAutility.getEm();
		return em.createQuery("select a from Allarme a ", Allarme.class).getResultList();
	}
	
	

}
