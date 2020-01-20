package DAO.Implementation;

import DAO.DAOFactory;
import DAO.interfaces.VilleDAO;

public class VilleDaoImpl implements VilleDAO {
    private DAOFactory daoFactory;

    public VilleDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
}
