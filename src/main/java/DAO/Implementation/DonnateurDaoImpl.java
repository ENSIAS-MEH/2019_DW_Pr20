package DAO.Implementation;

import DAO.DAOFactory;
import DAO.interfaces.DonnateurDAO;
import Model.Donnateur;

import java.sql.*;

public class DonnateurDaoImpl implements DonnateurDAO {

    private DAOFactory daoFactory;

    public DonnateurDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }


}
