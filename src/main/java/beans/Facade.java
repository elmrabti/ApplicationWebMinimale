package beans;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import Dao.AdresseDAO;
import Dao.IAdresseDAO;
import Dao.IPersonneDAO;
import Dao.PersonneDAO;

public class Facade {
	
	private Collection<Personne> per ;
	private Collection<Adresse> adr ;
	private Connection connection;

	
    public Facade(Connection connection) {
        this.connection = connection;
		per = new ArrayList<Personne>() ;
		adr = new ArrayList<Adresse>() ;
    }
	
	public Facade() {
		per = new ArrayList<Personne>() ;
		adr = new ArrayList<Adresse>() ;
	}
	
	public void ajoutPersonne(String nom, String prenom) throws SQLException {
		per.add(new Personne(nom, prenom)) ;
		IPersonneDAO personneDAO = new PersonneDAO(connection) ;
		personneDAO.create(new Personne(nom, prenom));
		
	
	}
	
	public void ajoutAdresse(int rue, String ville) {
		adr.add(new Adresse(rue, ville)) ;
		IAdresseDAO adresseDAO = new AdresseDAO(connection);
		adresseDAO.create(new Adresse(rue, ville));
		
	}
	
	public Collection<Personne> listePersonnes(){
		//return per ;/*
		IPersonneDAO personneDAO = new PersonneDAO(connection);
		try {
			return personneDAO.read() ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;
		}
		//*/
		
	}
	
	public Collection<Adresse> listeAdresses(){
 		//return adr ;/*
		IAdresseDAO adresseDAO = new AdresseDAO(connection) ;
		try {
			return adresseDAO.read();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		//*/
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
		System.out.println(personne);
		System.out.println(adresse);

		if(personne!=null && adresse != null) {
			//Collection<Adresse> liste = personne.getListeAdresses() ;
			//liste.add(adresse) ;
			//personne.setListeAdresses(liste);
			System.out.println("Ici 0000");
			personne.addAdresse(adresse);
		}
			
		
		
			
		
		
	}

}
