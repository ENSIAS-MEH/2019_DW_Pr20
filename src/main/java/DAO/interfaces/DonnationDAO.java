package DAO.interfaces;

import Model.Donnation;

import java.sql.Timestamp;
import java.util.List;

public interface DonnationDAO {

    boolean addDonnation(int idDonnateur, int idBS);
    boolean updateDonnation(int idDonnateur, Timestamp dateDonnation, Donnation donnation);
    boolean deleteDonnation(int idDonnateur, Timestamp dateDonnation);

    List<Donnation> getAllDennation();
    List<Donnation> getAllDonnationsVille(int idVille);                 //ville du BanqueSang pas du donnateur
    List<Donnation> getAllDonnationsBanq(int idBS);
    List<Donnation> getAllDonnationsGS(String nomGS);
    List<Donnation> getAllDonnationsVilleGS(int idVille, int idGS);     //ville du BanqueSang pas du donnateur
    List<Donnation> getAllDonnationsDonnateur(int idDonnateur);




    int DonnationsNbrPerVille(int idVille);                     //ville du BanqueSang pas du donnateur
    int DonnationsNbrPerGS(int idGS);
    int DonnationsNbrPerGS(int idGS, int idBS);
    int DonnationsNbrPerBanq(int idBS);
    int DonnationsNbrPerDonnateur(int idDonnateur);
    int DonnationsNbrPerVilleGS(int idVille, int idGS);         //ville du BanqueSang pas du donnateur


}
