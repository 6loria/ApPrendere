package business;

import java.util.logging.Logger;

import javax.persistence.EntityManager;

import project.Allarme;
import utility.JPAutility;



public class AllarmeManager  {
	private static Logger log = Logger.getLogger("app-rendere");
	
	public static void aggiungiAllarme (Allarme a) {
		EntityManager em = JPAutility.getEm();
		Allarme aDb = null;
		if(a.getId() != 0) {
			aDb = em.find(Allarme.class, a.getId());
		}
		if (aDb == null) {
			em.getTransaction().begin();
			em.persist(a); 
			em.getTransaction().commit();
		}
	}
	
	/*public static void aggiungiAllarme (int cadenza,
										int occorrenza,
										Date dataInizio,
										Date dataFine,
										int giornoSettimana,
										boolean presa) {
		EntityManager em =  JPAutility.getEm();
		Assunzioni assDb = em.find(Assunzioni.class, ass.getId());
		Terapia tDb = em.find(Terapia.class, t.getId());	
		if (assDb != null && tDb != null) {
			Allarme a = new Allarme();
			a.setId(a.getId());
			a.setCadenza (a.getCadenza()) ;
			a.setOccorrenza(a.getOccorrenza());
			a.setGiornoSettimana(a.getGiornoSettimana());
			a.setDataInizio(a.getDataInizio());
			a.setDataFine(a.getDataFine());
			a.setAssunzioni(ass);
			a.setTerapia(a.getTerapia());
			a.setEtichetta(a.getEtichetta());
			aggiungiAllarme(a);
			} 
	}*/
	
	
	

}
