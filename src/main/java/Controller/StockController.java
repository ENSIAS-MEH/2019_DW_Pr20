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
import java.util.List;

@WebServlet("/LesStatistiques")
public class StockController extends HttpServlet {

    private BanqueSangDAO banqueSangDAO;
    private VilleDAO villeDAO;
    private DAOFactory daoFactory = new DAOFactory("jdbc:mysql://localhost:3306/sang","root","");
    private HttpSession httpSession;
    private StockSangDAO stockSangDAO;
    private GroupeSanginDAO groupeSanginDAO;

    @Override
    public void init() throws ServletException {

        daoFactory.getInstance();
        banqueSangDAO = daoFactory.getBanqueSangDaoImpl();
        villeDAO = daoFactory.getVilleDaoImpl();
        stockSangDAO = daoFactory.getStockSangDaoImpl();
        groupeSanginDAO = daoFactory.getGroupeSanginDaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("From statistics");
        List<StockSang> stockSangList = new ArrayList<StockSang>();
        stockSangList= stockSangDAO.findStockByBanqueSang(9);   /*Id depuis la Session Aprés*/
        List<GroupeSangin> groupeSanginList = groupeSanginDAO.findAll();
        BanqueSang currentBanque = banqueSangDAO.findBanqueSangById(9);  /*Id depuis la Session Aprés*/
        request.setAttribute("groupList",groupeSanginList);
        request.setAttribute("currentBanque",currentBanque);
        request.setAttribute("stockList",stockSangList);
        this.getServletContext().getRequestDispatcher("/jsp/AfficherStock.jsp").forward(request,response);
    }

}
