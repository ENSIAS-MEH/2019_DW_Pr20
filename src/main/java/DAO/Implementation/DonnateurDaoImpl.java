package DAO.Implementation;

import DAO.DAOFactory;
import DAO.interfaces.DonnateurDAO;

public class DonnateurDaoImpl implements DonnateurDAO {
    private DAOFactory daoFactory;

    public DonnateurDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
}
