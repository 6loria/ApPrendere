package business;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import project.Farmaco;
import project.Terapia;
import project.Utente;
import utility.JPAutility;

public class UtenteManager {
	 
	private static Logger log = Logger.getLogger("app-rendere");
	
	public static void aggiungiUtente(Utente u) {
		EntityManager em = JPAutility.getEm();
		
		Utente uDb = em.find(Utente.class, u.getEmail());
		if (uDb == null) {
			em.getTransaction().begin();
			em.persist(u); 
			em.getTransaction().commit();
			log.log(Level.INFO, "Aggiunto utente");
		} else {
			log.log(Level.WARNING, "Utente esiste già");
		}
	}
	
	
	public static void modificaUtente(Utente u) {
		EntityManager em = JPAutility.getEm();
		Utente uDb = em.find(Utente.class, u.getEmail());
		if (uDb != null) {
			em.getTransaction().begin();
			uDb.setAttivo(u.getAttivo());
			em.getTransaction().commit();
			log.log(Level.INFO, "Utente modificato");

}
	}

	public void rimuoviTerapia(Utente u) {
		EntityManager em = JPAutility.getEm();
		Terapia tDb = em.find(Utente.class, u.getEmail());
		if (tDb != null) {
		em.getTransaction().begin();
	    em.remove(u);
		em.getTransaction().commit();
		log.log(Level.INFO, "Utente rimosso");
	}
}
	
	
	public static List<Utente> elencoUtenti() {
		EntityManager em = JPAutility.getEm();
		return em.createQuery("select u from Utente  u", Utente.class).getResultList();
	}
	
	

}
