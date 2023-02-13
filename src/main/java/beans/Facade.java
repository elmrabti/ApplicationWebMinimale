package beans;

import java.util.ArrayList;
import java.util.Collection;

public class Facade {
	
	Collection<Personne> per ;
	Collection<Adresse> adr ;
	
	public Facade() {
		per = new ArrayList<Personne>() ;
		adr = new ArrayList<Adresse>() ;
	}
	
	public void ajoutPersonne(String nom, String prenom) {
		per.add(new Personne(nom, prenom)) ;
	}
	
	public void ajoutAdresse(String rue, String ville) {
		adr.add(new Adresse(rue, ville)) ;
	}
	
	public Collection<Personne> listePersonnes(){
		return per ;
	}
	
	public Collection<Adresse> listeAdresses(){
		return adr ;
	}
	
	public void associer(int personneId, int adresseId) {
		Personne personne = null ;
		Adresse adresse = null ; 
		
		for(Personne p: per)
			if(p.getId() == personneId)
				personne = p ;
		for(Adresse a: adr)
			if(a.getId() == adresseId)
				adresse = a ;
		
		if(personne!=null && adresse == null) {
			Collection<Adresse> liste = personne.getListeAdresses() ;
			liste.add(adresse) ;
			personne.setListeAdresses(liste);
		}
			
		
		
			
		
		
	}

}
