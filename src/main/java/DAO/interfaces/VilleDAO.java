package DAO.interfaces;

import Model.Ville;

import java.util.List;

public interface VilleDAO {

    public void addVille(Ville ville);

    public List<Ville> getAllVille();

    public Ville getVilleById(int idVille);

    public Ville getVilleByName(String nomVille);

    public List<Ville> searchVilleByName(String nomVille);

    public void deleteVille(int idVille);
}
