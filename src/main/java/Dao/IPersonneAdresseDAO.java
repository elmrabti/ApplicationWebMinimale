package Dao;

import java.sql.SQLException;

import beans.Adresse;
import beans.Personne;

public interface IPersonneAdresseDAO {
		
	public void read();
	public void create(Personne p, Adresse a) throws SQLException;

}
