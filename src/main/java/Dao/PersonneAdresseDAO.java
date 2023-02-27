package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Adresse;
import beans.Personne;

public class PersonneAdresseDAO implements IPersonneAdresseDAO {
	
	private Connection connection ;

	public PersonneAdresseDAO(Connection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public void create(Personne p, Adresse a) throws SQLException {

		String insertQuery = "INSERT INTO adresse_personne (id_personne, id_adresse) VALUES (?, ?)";
        PreparedStatement preparedStatement = null;
        
		preparedStatement = connection.prepareStatement(insertQuery);
		preparedStatement.setInt(1, p.getId() );
		preparedStatement.setInt(2, a.getId() );

	    System.out.println(preparedStatement);
		int i = preparedStatement.executeUpdate();
	}
	
	@Override
	public void read() {

		
	}



	
	

}
