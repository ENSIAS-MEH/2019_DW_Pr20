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
    private int idBS = 9;

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
        request.setAttribute("groupList",groupeSanginList);
        request.setAttribute("currentBanque",currentBanque);
        request.setAttribute("stockList",stockSangList);
        //System.out.println(currentBanque.getNomBS());
        this.getServletContext().getRequestDispatcher("/jsp/AfficherStock.jsp").forward(request,response);
        //System.out.println(Integer.parseInt(request.getParameter("id")));
        /* Statistiques
        Gson gsonObj = new Gson();
        Map<Object,Object> map = null;
        List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();

        map = new HashMap<Object,Object>(); map.put("label", "A+");
        map.put("y", stockSangList.get(0).getQuantite()); list.add(map);
        map = new HashMap<Object,Object>(); map.put("label", "B+");
        map.put("y", stockSangList.get(1).getQuantite()); list.add(map);
        map = new HashMap<Object,Object>(); map.put("label", "AB+");
        map.put("y", stockSangList.get(2).getQuantite()); list.add(map);
        map = new HashMap<Object,Object>(); map.put("label", "O+");
        map.put("y", stockSangList.get(3).getQuantite()); list.add(map);
        map = new HashMap<Object,Object>(); map.put("label", "A-");
        map.put("y", stockSangList.get(4).getQuantite()); list.add(map);
        map = new HashMap<Object,Object>(); map.put("label", "B-");
        map.put("y", stockSangList.get(5).getQuantite()); list.add(map);
        map = new HashMap<Object,Object>(); map.put("label", "AB-");
        map.put("y", stockSangList.get(6).getQuantite()); list.add(map);
        map = new HashMap<Object,Object>(); map.put("label", "O-");
        map.put("y", stockSangList.get(7).getQuantite()); list.add(map);

        String dataPoints = gsonObj.toJson(list);
        request.setAttribute("dataPoints",dataPoints); */
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        System.out.println("Amin ZaaaaameeeeL");
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
