package Controller;

import DAO.DAOFactory;
import DAO.interfaces.BanqueSangDAO;
import DAO.interfaces.GroupeSanginDAO;
import DAO.interfaces.StockSangDAO;
import DAO.interfaces.VilleDAO;
import Model.BanqueSang;
import Model.GroupeSangin;
import Model.StockSang;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@WebServlet("/Statistiques")
public class StockController extends HttpServlet {

    private BanqueSangDAO banqueSangDAO;
    private VilleDAO villeDAO;
    private DAOFactory daoFactory = new DAOFactory("jdbc:mysql://localhost:3306/sang","root","");
    private HttpSession httpSession;
    private StockSangDAO stockSangDAO;
    private GroupeSanginDAO groupeSanginDAO;

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
        HttpSession session = request.getSession(false);
        BanqueSang banq = (BanqueSang)session.getAttribute("banquesang");
        int idBS = banq.getIdBS();

        List<Integer> stockSangList = stockSangDAO.statsByBanque(idBS);   /*Id depuis la Session Aprés*/
        System.out.println(stockSangList);
        List<GroupeSangin> groupeSanginList = groupeSanginDAO.findAll();
        BanqueSang currentBanque = banqueSangDAO.findBanqueSangById(idBS);  /*Id depuis la Session Aprés*/
        request.setAttribute("groupList",groupeSanginList);
        request.setAttribute("currentBanque",currentBanque);
        request.setAttribute("stockList",stockSangList);
        this.getServletContext().getRequestDispatcher("/jsp/AfficherStock.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        HttpSession session = request.getSession(false);
        BanqueSang banq = (BanqueSang)session.getAttribute("banquesang");
        int idBS = banq.getIdBS();
        int idGroup = Integer.parseInt(request.getParameter("id"));
        System.out.println("idPOST = "+idGroup);
        StockSang stockSang  = stockSangDAO.findStockById(idBS,idGroup);
        int quantite = Integer.parseInt(request.getParameter("quantite"));
        stockSang.setQuantite(quantite);
        stockSangDAO.updateStockSang(stockSang);
        this.init();
        this.doGet(request,response);


    }

}