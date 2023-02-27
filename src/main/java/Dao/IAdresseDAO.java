package Dao;

import java.sql.SQLException;
import java.util.Collection;

import beans.Adresse;

public interface IAdresseDAO {
    public void create(Adresse a);
    public Adresse read(int id);
    public Collection<Adresse> read() throws SQLException;
    public void update(Adresse a);
    public void delete(int id);
}
