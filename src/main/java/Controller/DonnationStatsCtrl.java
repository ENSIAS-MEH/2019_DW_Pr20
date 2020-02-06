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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/DonnationStats")
public class DonnationStatsCtrl extends HttpServlet {

    private BanqueSangDAO banqueSangDAO;
    private VilleDAO villeDAO;
    private DAOFactory daoFactory = new DAOFactory("jdbc:mysql://localhost:3306/sang","root","");
    private HttpSession httpSession;
    private StockSangDAO stockSangDAO;
    private GroupeSanginDAO groupeSanginDAO;
    private int idBS = 9; /*Depuis la Sessions*/

    @Override
    public void init() throws ServletException {

        daoFactory.getInstance();
        banqueSangDAO = daoFactory.getBanqueSangDaoImpl();
        villeDAO = daoFactory.getVilleDaoImpl();
        stockSangDAO = daoFactory.getStockSangDaoImpl();
        groupeSanginDAO = daoFactory.getGroupeSanginDaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("action") == null || request.getParameter("action").equals("")){

            List<GroupeSangin> groupeSanginList = groupeSanginDAO.findAll();
            List<Ville> villes = villeDAO.getAllVille();
            List<BanqueSang> banqueSangList = banqueSangDAO.findAllBanqueSang();
            ArrayList<Integer> allStock = (ArrayList<Integer>) stockSangDAO.AllstocStatistic();

            System.out.println("All Stock ;"+allStock);

            request.setAttribute("villes",villes);
            request.setAttribute("banqueSangList",banqueSangList);
            request.setAttribute("groupList",groupeSanginList);

            this.getServletContext().getRequestDispatcher("/jsp/DonnationStats.jsp").forward(request,response);
        }
    }
}
