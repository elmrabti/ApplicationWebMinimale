package beans;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.catalina.ha.backend.CollectedInfo;

public class Personne {
	
	private int id ;
	private String nom ;
	private String prenom ;
	private Collection<Adresse> listeAdresses ;
	private static int ctr = 0 ;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public Collection<Adresse> getListeAdresses() {
		return listeAdresses;
	}
	
	public void setListeAdresses(Collection<Adresse> listeAdresses) {
		this.listeAdresses = listeAdresses;
	}
	
	public Personne(String nom, String prenom) {
		super();
		this.id = ctr++ ;
		this.nom = nom ;
		this.prenom = prenom ;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public void addAdresse(Adresse a) {
		if (listeAdresses == null) {
		    listeAdresses = new ArrayList<>();
		}
		listeAdresses.add(a);
		System.out.println("encore");
	}
	
	
	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	
	
	

}
