package project;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;

@Entity
@Inheritance
public class Utente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String email;
	private String nome;
	private String cognome;
	private String password;
	private Boolean attivo;
	@OneToMany(mappedBy="utente")
	private List<Terapia> terapia;
	
	
	
	public Utente() {
		super();
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public String getCognome() {
		return cognome;
	}

	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	
	public String getPassword() {
		return password;
	}

	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getAttivo() {
		return attivo;
	}
	public void setAttivo(Boolean attivo) {
		this.attivo = attivo;
	}

	public List<Terapia> getTerapia() {
		return terapia;
	}

	public void setTerapia(List<Terapia> terapia) {
		this.terapia = terapia;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
