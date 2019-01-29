package business;

import java.util.logging.Logger;

import javax.persistence.EntityManager;

import project.Utente;
import utility.EntityManagerProvider;
import utility.JPAutility;

public class AccessoApplicazione {
	private static Logger log = Logger.getLogger("project");

	public static Utente login(String email, String password) {
		Utente result = null;
		EntityManager em = EntityManagerProvider.getEntityManager();
		Utente u = em.find(Utente.class, email);
		if (u != null) {
			if (!u.getAttivo()) {
				log.warning("accesso con utente non attivo");
			} else if (!u.getPassword().equals(password)) {
				log.warning("accesso con password errata");
			} else {
				result = u;
			}
		} else {
			log.warning("l'utente " + email + " non esiste");
		}
		log.info("accesso di " + email + ": " + (result == null ? "KO" : "OK"));
		return result;
	}

}
