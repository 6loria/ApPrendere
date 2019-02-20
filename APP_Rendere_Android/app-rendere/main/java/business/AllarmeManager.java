package business;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import project.Allarme;
import utility.JPAutility;

public class AllarmeManager {
	private static Logger log = Logger.getLogger("app-rendere");

	public static void aggiungiAllarme(Allarme a) {
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

	public static void modificaAllarme(Allarme a) {
		EntityManager em = JPAutility.getEm();
		Allarme aDb = em.find(Allarme.class, a.getId());
		if (aDb != null) {
			em.getTransaction().begin();
			// aDb.setAllarme(a.getAllarme());
			em.getTransaction().commit();
			log.log(Level.INFO, "Allarme modificato");
		}
	}
	/*
	 * public static void aggiungiAllarme (int cadenza, int occorrenza, Date
	 * dataInizio, Date dataFine, int giornoSettimana, boolean presa) {
	 * EntityManager em = JPAutility.getEm(); Assunzioni assDb =
	 * em.find(Assunzioni.class, ass.getId()); Terapia tDb = em.find(Terapia.class,
	 * t.getId()); if (assDb != null && tDb != null) { Allarme a = new Allarme();
	 * a.setId(a.getId()); a.setCadenza (a.getCadenza()) ;
	 * a.setOccorrenza(a.getOccorrenza());
	 * a.setGiornoSettimana(a.getGiornoSettimana());
	 * a.setDataInizio(a.getDataInizio()); a.setDataFine(a.getDataFine());
	 * a.setAssunzioni(ass); a.setTerapia(a.getTerapia());
	 * a.setEtichetta(a.getEtichetta()); aggiungiAllarme(a); } }
	 */

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
