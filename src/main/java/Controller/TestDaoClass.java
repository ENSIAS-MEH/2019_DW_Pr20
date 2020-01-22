package Controller;

import DAO.DAOFactory;
import DAO.Implementation.StockSangDaoImpl;
import DAO.interfaces.StockSangDAO;
import Model.StockSang;

public class TestDaoClass {
    public static void main(String[] args){
        StockSangDAO stockSangdao = new StockSangDaoImpl(new DAOFactory("jdbc:mysql://localhost:3306/sang","root",""));
        //System.out.println(stockSangdao.findStockById(4,1).toString());
        //System.out.println(stockSangdao.findStockByBanqueSang(2).toString());
        //System.out.println(stockSangdao.findAll().toString());
        /*Ajout Stock
        StockSang stock = new StockSang(1,1,21);
        stockSangdao.ajouterStockSang(stock);*/

        /*delete Stock*/
        StockSang stock = new StockSang(1,1,21);
        stockSangdao.deleteStockSang(stock);


    }
}
