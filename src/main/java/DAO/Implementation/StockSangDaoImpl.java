package DAO.Implementation;

import DAO.DAOFactory;
import DAO.interfaces.StockSangDAO;

public class StockSangDaoImpl implements StockSangDAO {
    private DAOFactory daoFactory;

    public StockSangDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
}
