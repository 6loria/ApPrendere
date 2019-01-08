package project;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;

@Entity
@Inheritance
public class Utente {
	
	private String nome;
	private String cognome;
	@Id
	private String email;
	private String password;
	private Boolean attivo;
	
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
	
	public Object getRemove() {
		
		return null;
	}


}
