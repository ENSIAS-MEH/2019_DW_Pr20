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

    List<Donnation> getAllDonnationsDonnateur(int idDonnateur);
/*
    int countDonnations(int villeFilter, int groupeFilter);
    int countDonnationsPerCenter(int idCentre);

*/
}
