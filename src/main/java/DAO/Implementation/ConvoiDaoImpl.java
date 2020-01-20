package DAO.Implementation;

import DAO.DAOFactory;
import DAO.interfaces.ConvoiDAO;

public class ConvoiDaoImpl implements ConvoiDAO {
    private DAOFactory daoFactory;

    public ConvoiDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
}
