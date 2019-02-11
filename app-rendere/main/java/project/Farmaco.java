package project;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Farmaco  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String aic;
	private String nome;
	private String produttore;
	private Double concentrazione;
	private Integer unita;
	private String utilizzo;
	private Double prezzo;
	private String principioAttivo;
	
	@OneToOne(mappedBy="farmaco")
	private FogliettoIllustrativo fogliettoIllustrativo;

	@ManyToOne
	private Terapia terapia;
	
	public Farmaco() {
		super();
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getProduttore() {
		return produttore;
	}
	
	public void setProduttore(String produttore) {
		this.produttore = produttore;
	}
	
	public String getAic() {
		return aic;
	}
	
	public void setAic(String aic) {
		this.aic = aic;
	}
	
	public Double getConcentrazione() {
		return concentrazione;
	}
	
	public void setConcentrazione(Double concentrazione) {
		this.concentrazione = concentrazione;
	}
	
	public Integer getUnita() {
		return unita;
	}
	
	public void setUnita(Integer unita) {
		this.unita = unita;
	}
	
	public String getUtilizzo() {
		return utilizzo;
	}
	
	public void setUtilizzo(String utilizzo) {
		this.utilizzo = utilizzo;
	}

	public Double getPrezzo() {
		return prezzo;
	}
	
	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public FogliettoIllustrativo getFogliettoIllustrativo() {
		return fogliettoIllustrativo;
	}

	public void setFogliettoIllustrativo(FogliettoIllustrativo fogliettoIllustrativo) {
		this.fogliettoIllustrativo = fogliettoIllustrativo;
	}

	public Terapia getTerapia() {
		return terapia;
	}

	public void setTerapia(Terapia terapia) {
		this.terapia = terapia;
	}

	
	public String getPrincipioAttivo() {
		return principioAttivo;
	}

	public void setPrincipioAttivo(String principioAttivo) {
		this.principioAttivo = principioAttivo;
	}
}
