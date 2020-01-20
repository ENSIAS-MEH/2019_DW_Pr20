package DAO.Implementation;

import DAO.DAOFactory;
import DAO.interfaces.GroupeSanginDAO;

public class GroupeSanginDaoImpl implements GroupeSanginDAO {
    private DAOFactory daoFactory;

    public GroupeSanginDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
}
