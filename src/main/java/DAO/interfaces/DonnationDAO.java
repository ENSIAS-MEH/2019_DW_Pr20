package DAO.interfaces;

import Model.Donnation;

import java.sql.Timestamp;
import java.util.List;

public interface DonnationDAO {

    boolean addDonnation(Donnation donnation);
    boolean updateDonnation(int idDonnateur, Timestamp dateDonnation, Donnation donnation);
    boolean deleteDonnation(int idDonnateur, Timestamp dateDonnation);

    List<Donnation> getAllDennation();
    List<Donnation> getAllDonnationsVille(int idVille);
    List<Donnation> getAllDonnationsBanq(int idBS);
    List<Donnation> getAllDonnationsVilleGS(int idVille, int idGS);
    List<Donnation> getAllDonnationsDonnateur(int idDonnateur);

/*
    int countDonnationsPerVille(int idVille);
    int countDonnationsPerBanq(int idBS);
    int countDonnationsPerDonnateur(int idDonnateur);
    int countDonnationsPerVilleGS(int idVille, int idGS);

*/
}
