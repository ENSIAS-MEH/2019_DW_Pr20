package DAO.Implementation;

import DAO.DAOFactory;
import DAO.interfaces.BanqueSangDAO;

public class BanqueSangDaoImpl implements BanqueSangDAO {
    private DAOFactory daoFactory;

    public BanqueSangDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
}
