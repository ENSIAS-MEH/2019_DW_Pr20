package Controller;

import DAO.DAOFactory;
import DAO.Implementation.BanqueSangDaoImpl;
import DAO.Implementation.StockSangDaoImpl;
import DAO.interfaces.BanqueSangDAO;
import DAO.interfaces.StockSangDAO;
import Model.BanqueSang;
import Model.StockSang;

import java.util.ArrayList;
import java.util.List;

public class TestDaoClass {
    public static void main(String[] args){
        StockSangDAO stockSangdao = new StockSangDaoImpl(new DAOFactory("jdbc:mysql://localhost:3306/sang","root",""));
        //System.out.println(stockSangdao.findStockById(4,1).toString());
        //System.out.println(stockSangdao.findStockByBanqueSang(2).toString());
        //System.out.println(stockSangdao.findAll().toString());
        /*Ajout Stock
        StockSang stock = new StockSang(1,1,21);
        stockSangdao.ajouterStockSang(stock);*/

        /*delete Stock
        StockSang stock = new StockSang(1,1,11);
        stockSangdao.deleteStockSang(stock);*/

        /*StockPerBanque
        System.out.println("Stock per Banque : "+stockSangdao.stockPerBanque(2));*/

        /*Ajouter banque with stock
        BanqueSangDAO banqueSangDAO = new BanqueSangDaoImpl(new DAOFactory("jdbc:mysql://localhost:3306/sang","root",""));
        BanqueSang banqueSang =
                new BanqueSang("Assalam", "asalam@email.com", "0621212121", "Testtt", "hay nours", 1);
        banqueSangDAO.ajouterBanqueSang(banqueSang);
        System.out.println(banqueSang.getIdVille());*/

        /*Test AllStockStat*/
        List<Integer> stocks = new ArrayList<Integer>();
        stocks = stockSangdao.AllstocStatistic();
        System.out.println("Stock  :"+stocks);
    }
}
