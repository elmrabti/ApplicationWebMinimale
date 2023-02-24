package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	public Personne read(int id) {
		// TODO Auto-generated method stub
		return null;
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
