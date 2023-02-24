package Dao;

import java.sql.SQLException;

import beans.Personne;

public interface IPersonneDAO {
    public void create(Personne p) throws SQLException;
    public Personne read(int id);
    public void update(Personne p);
    public void delete(int id);
}
