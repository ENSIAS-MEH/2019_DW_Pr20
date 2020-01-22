package DAO.interfaces;

import Model.AlerteBesoin;

import java.util.List;

public interface AlerteBesoinDAO {

    public boolean addAlerte(AlerteBesoin ab);

    //seulement les alertes actives classées par date
    public List<AlerteBesoin> getAllAlertes();

    //Les alertes publiées par un banque de sang
    public List<AlerteBesoin> getAlerteByBS(int idBS);

    //les alertes qui concernent un groupe sangin
    public List<AlerteBesoin> getAlerteByGS(int idGS);

    public boolean updateAlerte(AlerteBesoin alerteBesoin);

    public boolean deleteAlerte(int idAlerte);

    public boolean disableAlerte(int idAlerte);

    public int getNbrAlerteByBS(int idBS);
}
