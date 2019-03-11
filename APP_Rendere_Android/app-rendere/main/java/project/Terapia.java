package project;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Terapia implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Utente utente;
	
	@OneToMany(mappedBy="terapia")
	private List<Farmaco> farmaci;
	
	@ManyToOne
	private Allarme allarmi;
	
	public Terapia() {
		super();
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utenti) {
		this.utente = utenti;
	}

	public List<Farmaco> getFarmaci() {
		return farmaci;
	}

	public void setFarmaci(List<Farmaco> farmaci) {
		this.farmaci = farmaci;
	}

	public static long getSerializeversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Allarme getAllarmi() {
		return allarmi;
	}

	public void setAllarmi(Allarme allarmi) {
		this.allarmi = allarmi;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
