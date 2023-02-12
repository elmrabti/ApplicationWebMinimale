package beans;

import java.util.Collection;

import org.apache.catalina.ha.backend.CollectedInfo;

public class Personne {
	
	private String nom ;
	private String prenom ;
	private Collection<Adresse> listeAdresses ;
	
	
	public Collection<Adresse> getListeAdresses() {
		return listeAdresses;
	}
	
	public void setListeAdresses(Collection<Adresse> listeAdresses) {
		this.listeAdresses = listeAdresses;
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
	
	
	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	
	
	

}
