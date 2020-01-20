package DAO.Implementation;

import DAO.DAOFactory;
import DAO.interfaces.DonnationDAO;

public class DonnationDaoImpl implements DonnationDAO {
    private DAOFactory daoFactory;

    public DonnationDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
}
