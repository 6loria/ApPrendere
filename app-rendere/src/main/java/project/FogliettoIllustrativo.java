package project;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class FogliettoIllustrativo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@OneToOne
	private Farmaco farmaco;
	private String indicazioni;
	private String precauzioni;
	private String avvertenze;
	private String sovradosaggio;
	private String scadenzaConservazione;
	private String controindicazioni;
	private String interazioni;
	private String modiDuso;
	private String effettiIndesiderati;
	private String principioAttivo;
	private String composizione;

	public FogliettoIllustrativo() {
		super();
	}

	public Farmaco getFarmaco() {
		return farmaco;
	}

	public void setFarmaco(Farmaco farmaco) {
		this.farmaco = farmaco;
	}

	public String getIndicazioni() {
		return indicazioni;
	}

	public void setIndicazioni(String indicazioni) {
		this.indicazioni = indicazioni;
	}

	public String getPrecauzioni() {
		return precauzioni;
	}

	public void setPrecauzioni(String precauzioni) {
		this.precauzioni = precauzioni;
	}

	public String getAvvertenze() {
		return avvertenze;
	}

	public void setAvvertenze(String avvertenze) {
		this.avvertenze = avvertenze;
	}

	public String getSovradosaggio() {
		return sovradosaggio;
	}

	public void setSovradosaggio(String sovradosaggio) {
		this.sovradosaggio = sovradosaggio;
	}

	public String getScadenzaConservazione() {
		return scadenzaConservazione;
	}

	public void setScadenzaConservazione(String scadenzaConservazione) {
		this.scadenzaConservazione = scadenzaConservazione;
	}

	public String getControindicazioni() {
		return controindicazioni;
	}

	public void setControindicazioni(String controindicazioni) {
		this.controindicazioni = controindicazioni;
	}

	public String getInterazioni() {
		return interazioni;
	}

	public void setInterazioni(String interazioni) {
		this.interazioni = interazioni;
	}

	public String getModiDuso() {
		return modiDuso;
	}

	public void setModiDuso(String modiDuso) {
		this.modiDuso = modiDuso;
	}

	public String getEffettiIndesiderati() {
		return effettiIndesiderati;
	}

	public void setEffettiIndesiderati(String effettiIndesiderati) {
		this.effettiIndesiderati = effettiIndesiderati;
	}

	public String getPrincipioAttivo() {
		return principioAttivo;
	}

	public void setPrincipioAttivo(String principioAttivo) {
		this.principioAttivo = principioAttivo;
	}

	public String getComposizione() {
		return composizione;
	}

	public void setComposizione(String composizione) {
		this.composizione = composizione;
	}

}
