package Dao;

import beans.Adresse;

public interface IAdresseDAO {
    public void create(Adresse a);
    public Adresse read(int id);
    public void update(Adresse a);
    public void delete(int id);
}
