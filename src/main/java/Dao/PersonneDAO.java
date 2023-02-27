package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.catalina.ha.backend.CollectedInfo;

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
		
		String insertQuery = "INSERT INTO personne (id, nom, prenom) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = null;
        
		preparedStatement = connection.prepareStatement(insertQuery);
		preparedStatement.setInt(1, p.getId() );
		preparedStatement.setString(2, p.getNom() );
		preparedStatement.setString(3, p.getPrenom());

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
		
		if(resultat.next()) {
			String nom = resultat.getString("nom");
			String prenom = resultat.getString("prenom") ;
			personnes.add(new Personne(nom,prenom)) ;
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
