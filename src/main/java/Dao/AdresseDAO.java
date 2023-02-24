package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Adresse;

public class AdresseDAO implements IAdresseDAO {
	
	private Connection connection ;

	public AdresseDAO(Connection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public void create(Adresse a) {
		// TODO Auto-generated method stub
		
		String insertQuery = "INSERT INTO adresse (id, rue, ville) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(insertQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Inserer les parametres 
        
        try {
			preparedStatement.setInt(1, a.getId() );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			preparedStatement.setString(2, a.getRue() );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        try {
			preparedStatement.setString(3, a.getVille());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
        try {
        	System.out.println(preparedStatement);
			int i = preparedStatement.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Adresse read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Adresse a) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}
