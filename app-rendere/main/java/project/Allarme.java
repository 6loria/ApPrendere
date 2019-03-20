package project;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Allarme implements Serializable {
	private final static long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String etichetta;
	
	@OneToMany(mappedBy="allarmi")
	private List<Terapia>terapia;
	private int cadenza;
	private int occorrenza;
	@Temporal(TemporalType.DATE)
	private Date dataInizio;
	@Temporal(TemporalType.DATE)
	private Date dataFine;
	private int giornoSettimana;
	private boolean presa;
	@ManyToOne
	private Assunzioni assunzioni;
	
	public Allarme() {
		super();
	}

	public List<Terapia> getTerapia() {
		return terapia;
	}

	public void setTerapia(List<Terapia> terapia) {
		this.terapia = terapia;
	}

	public int getCadenza() {
		return cadenza;
	}

	public void setCadenza(int cadenza) {
		this.cadenza = cadenza;
	}

	public int getOccorrenza() {
		return occorrenza;
	}

	public void setOccorrenza(int occorrenza) {
		this.occorrenza = occorrenza;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public int getGiornoSettimana() {
		return giornoSettimana;
	}

	public void setGiornoSettimana(int giornoSettimana) {
		this.giornoSettimana = giornoSettimana;
	}

	public boolean isPresa() {
		return presa;
	}

	public void setPresa(boolean presa) {
		this.presa = presa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Assunzioni getAssunzioni() {
		return assunzioni;
	}

	public void setAssunzioni(Assunzioni assunzioni) {
		this.assunzioni = assunzioni;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the etichetta
	 */
	public String getEtichetta() {
		return etichetta;
	}

	/**
	 * @param etichetta the etichetta to set
	 */
	public void setEtichetta(String etichetta) {
		this.etichetta = etichetta;
	}

	

}
