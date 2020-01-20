package DAO.Implementation;

import DAO.DAOFactory;
import DAO.interfaces.PlanningDAO;

public class PlanningDaoImpl implements PlanningDAO {
    private DAOFactory daoFactory;

    public PlanningDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
}
