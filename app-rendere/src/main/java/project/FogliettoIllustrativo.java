package project;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
  public class FogliettoIllustrativo {
	@Id
	@OneToOne
	private Farmaco farmaco;



	
	public Farmaco getFarmaco() {
		return farmaco;
	}


	
	public void setFarmaco(Farmaco farmaco) {
		this.farmaco = farmaco;
	}

}
