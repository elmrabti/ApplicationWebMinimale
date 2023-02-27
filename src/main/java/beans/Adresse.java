package beans;

import util.Instance;

public class Adresse {
	
	private int rue ;
	private String ville ;
	private int id ;
	private static Instance instance = new Instance() ;
	
	public Adresse(int rue, String ville) {
		super();
		this.id = instance.getNext();
		this.rue = rue;
		this.ville = ville;
	}
	
	public Adresse(int id, int rue, String ville) {
		super();
		this.id = id;
		this.rue = rue;
		this.ville = ville;
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getRue() {
		return rue;
	}
	public void setRue(int rue) {
		this.rue = rue;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	@Override
	public String toString() {
		return "Adresse [rue=" + rue + ", ville=" + ville + "]";
	}
	
	
	
	
	

}
