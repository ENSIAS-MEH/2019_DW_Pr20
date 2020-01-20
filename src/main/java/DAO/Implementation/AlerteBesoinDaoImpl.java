package DAO.Implementation;

import DAO.DAOFactory;
import DAO.interfaces.AlerteBesoinDAO;

public class AlerteBesoinDaoImpl implements AlerteBesoinDAO {
    private DAOFactory daoFactory;

    public AlerteBesoinDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
}
