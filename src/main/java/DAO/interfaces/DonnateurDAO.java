package DAO.interfaces;

import Model.Donnateur;

import java.util.List;

public interface DonnateurDAO {

    //Crud
    boolean addDonnateur(Donnateur donnateur);
    boolean updateDonnateur(Donnateur donnateur);
    boolean deleteDonnateur(String email);

    //get data for one donor
    Donnateur getDonnateur(String email, String password);
    Donnateur getDonnateurById(int id);

    //check if a donor exist
    boolean findDonnateurByMail(String mail);

    //get data for multiple donors
    List<Donnateur> getAllDonnateurs();
    List<Donnateur> getDonnateursByCity(int idVille);
    List<Donnateur> getDonnateursByGrpSg(int idGS);
    List<Donnateur> getAllDonnateursVilleGS(int idVille, int idGS);

    int donnationLastM(int idDonnateur);        //return si un donateur a des donations dans les 3 dernièrs mois

    //Pour les statistiques
    int donorsNbrPerCity(int idVille);
    int donorsNbrPerGrpSg(int idGS);

}
