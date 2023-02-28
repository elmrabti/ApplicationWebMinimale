package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.catalina.ha.backend.CollectedInfo;

import beans.Adresse;
import beans.Personne;

public class PersonneDAO implements IPersonneDAO {
	
	private Connection connection ;
	
	

	public PersonneDAO(Connection connection) {
		super();
		this.connection = connection;
	}




	@Override
	public void create(Personne p) throws SQLException {
		// TODO Auto-generated method stub
		
		String insertQuery = "INSERT INTO personne (nom, prenom) VALUES (?, ?)";
        PreparedStatement preparedStatement = null;
        
		preparedStatement = connection.prepareStatement(insertQuery);
		preparedStatement.setString(1, p.getNom() );
		preparedStatement.setString(2, p.getPrenom());

	    System.out.println(preparedStatement);
		int i = preparedStatement.executeUpdate();
			
	}


	

	

	@Override
	public Personne read(int id) throws SQLException {
		// TODO Auto-generated method stub
		
		Statement statement = null ;
		ResultSet resultat = null ;
		String select ="SELECT * from personne where id= ?;" ;
		PreparedStatement preparedStatement = connection.prepareStatement(select);
		preparedStatement.setInt(1, id );
		
		if(resultat.next()) {
			String nom = resultat.getString("nom");
			String prenom = resultat.getString("prenom") ;
			return new Personne("nom","prenom");
		}
		return null;
	}
	
	
	public Collection<Personne> read() throws SQLException {
		// TODO Auto-generated method stub
		Collection<Personne> personnes = new ArrayList<>() ;
		Statement statement = null ;
		ResultSet resultat = null ;
		statement = connection.createStatement();
		String query ="SELECT * from personne;" ;
		resultat = statement.executeQuery(query);
		
		while(resultat.next()) {
			int id = resultat.getInt("id");
			String nom = resultat.getString("nom");
			String prenom = resultat.getString("prenom") ;
			
			Personne personne = new Personne(id,nom,prenom) ;

			
			String findAdresses = "SELECT id_adresse from adresse_personne where id_personne= ? ;";
			PreparedStatement preparedStatement = connection.prepareStatement(findAdresses);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery() ;
			
			while(result.next()) {
				IAdresseDAO adresseDAO = new AdresseDAO(connection) ;
				Adresse a = adresseDAO.read(result.getInt("id_adresse") ) ;                       
				personne.addAdresse(a);
				
			}
			
			personnes.add(personne) ;
			
			
			
		}
		
		return personnes;
	}
	
	

	@Override
	public void update(Personne p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}
