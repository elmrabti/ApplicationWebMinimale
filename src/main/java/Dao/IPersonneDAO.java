package Dao;

import java.sql.SQLException;
import java.util.Collection;

import beans.Personne;

public interface IPersonneDAO {
    public void create(Personne p) throws SQLException;
    public Personne read(int id) throws SQLException;
    public Collection<Personne> read() throws SQLException;
    public void update(Personne p);
    public void delete(int id);
}
