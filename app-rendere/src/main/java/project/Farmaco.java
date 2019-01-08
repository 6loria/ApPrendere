package project;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Farmaco {
	
	private String nome;
	private String produttore;
	@Id
	private String aic;
	private double concentrazione;
	private int unita;
	private String utilizzo;
	private String principioAttivo;
	private double prezzo;
	@OneToOne
	private FogliettoIllustrativo fogliettoIllustrativo;
	
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
	
	public double getConcentrazione() {
		return concentrazione;
	}
	
	public void setConcentrazione(double concentrazione) {
		this.concentrazione = concentrazione;
	}
	
	public int getUnita() {
		return unita;
	}
	
	public void setUnita(int unita) {
		this.unita = unita;
	}
	
	public String getUtilizzo() {
		return utilizzo;
	}
	
	public void setUtilizzo(String utilizzo) {
		this.utilizzo = utilizzo;
	}
	
	public String getPrincipioAttivo() {
		return principioAttivo;
	}
	
	public void setPrincipioAttivo(String principioAttivo) {
		this.principioAttivo = principioAttivo;
	}
	
	public double getPrezzo() {
		return prezzo;
	}
	
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public FogliettoIllustrativo getFogliettoIllustrativo() {
		return fogliettoIllustrativo;
	}

	public void setFogliettoIllustrativo(FogliettoIllustrativo fogliettoIllustrativo) {
		this.fogliettoIllustrativo = fogliettoIllustrativo;
	}

	

	
}
