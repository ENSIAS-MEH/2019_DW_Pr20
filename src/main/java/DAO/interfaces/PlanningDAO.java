package DAO.interfaces;

import Model.Planning;

import java.sql.Timestamp;
import java.util.List;

public interface PlanningDAO {

    Planning findPlanningByIdConvoiAndIdVilleAnddate(int idConvoi,int idVille,Timestamp dateConvoi_debut);
    List<Planning> findPalnningByidConvoi(int idConvoi);
    List<Planning> findPalnningByidVille(int idVille);
    List<Planning> findPalnningBydate(Timestamp dateConvoi_debut,Timestamp dateConvoi_fin);

    void addPlanning(Planning planning);
    void updatePlanning(Planning planning);
    void deletePlanning(Planning planning);

}
