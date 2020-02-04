package Controller;

import DAO.DAOFactory;
import DAO.interfaces.BanqueSangDAO;
import DAO.interfaces.GroupeSanginDAO;
import DAO.interfaces.StockSangDAO;
import DAO.interfaces.VilleDAO;
import Model.BanqueSang;
import Model.GroupeSangin;
import Model.StockSang;
import Model.Ville;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class AdminStatistics extends HttpServlet {

    private BanqueSangDAO banqueSangDAO;
    private VilleDAO villeDAO;
    private DAOFactory daoFactory = new DAOFactory("jdbc:mysql://localhost:3306/sang","root","");
    private HttpSession httpSession;
    private StockSangDAO stockSangDAO;
    private GroupeSanginDAO groupeSanginDAO;
    private int idBS = 9; /*Depuis la Sessions*/

    @Override
    public void init() throws ServletException  {

        daoFactory.getInstance();
        banqueSangDAO = daoFactory.getBanqueSangDaoImpl();
        villeDAO = daoFactory.getVilleDaoImpl();
        stockSangDAO = daoFactory.getStockSangDaoImpl();
        groupeSanginDAO = daoFactory.getGroupeSanginDaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("From statistics");
        List<StockSang> stockSangList = new ArrayList<StockSang>();
        stockSangList= stockSangDAO.findStockByBanqueSang(idBS);   /*Id depuis la Session Aprés*/
        List<GroupeSangin> groupeSanginList = groupeSanginDAO.findAll();
        BanqueSang currentBanque = banqueSangDAO.findBanqueSangById(idBS);  /*Id depuis la Session Aprés*/
        List<Ville> villes = villeDAO.getAllVille();
        List<BanqueSang> banqueSangList = banqueSangDAO.findAllBanqueSang();
        ArrayList<Integer> allStock = (ArrayList<Integer>) stockSangDAO.AllstocStatistic();
        System.out.println("All Stock ;"+allStock);

        request.setAttribute("allStock",allStock);
        request.setAttribute("villes",villes);
        request.setAttribute("banqueSangList",banqueSangList);
        request.setAttribute("groupList",groupeSanginList);
        request.setAttribute("currentBanque",currentBanque);
        request.setAttribute("stockList",stockSangList);
        this.getServletContext().getRequestDispatcher("/jsp/AdminStockStatistics.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        int idGroup = Integer.parseInt(request.getParameter("id"));
        System.out.println("idPOST = "+idGroup);
        //BanqueSang currentbanqueSang = banqueSangDAO.findBanqueSangById(idBS);
        StockSang stockSang  = stockSangDAO.findStockById(idBS,idGroup);
        int quantite = Integer.parseInt(request.getParameter("quantite"));
        stockSang.setQuantite(quantite);
        stockSangDAO.updateStockSang(stockSang);
        this.init();
        this.doGet(request,response);


    }

}
