package Controller;

import DAO.DAOFactory;
import DAO.interfaces.*;
import Model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/Donnation")
public class DonnationController extends HttpServlet {
    private DAOFactory daoFactory = new DAOFactory("jdbc:mysql://localhost:3306/sang","root","");
    private HttpSession httpSession;

    private DonnationDAO donnationDAO;
    private DonnateurDAO donnateurDAO;
    private VilleDAO villeDAO;
    private GroupeSanginDAO groupeSanginDAO;
    private BanqueSangDAO banqueSangDAO;

    @Override
    public void init() throws ServletException {

        daoFactory.getInstance();

        donnationDAO = daoFactory.getDonnationDaoImpl();
        donnateurDAO = daoFactory.getDonnateurDaoImpl();
        villeDAO = daoFactory.getVilleDaoImpl();
        groupeSanginDAO = daoFactory.getGroupeSanginDaoImpl();
        banqueSangDAO = daoFactory.getBanqueSangDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            showDonnations(request, response);

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showDonnations(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{

        List<Donnation> donnationList = donnationDAO.getAllDennation();
        List<Ville> villes = villeDAO.getAllVille();
        List<Donnateur> donnateurs = donnateurDAO.getAllDonnateurs();
        List<GroupeSangin> gsList = groupeSanginDAO.findAll();
        List<BanqueSang> banqueSangList = banqueSangDAO.findAllBanqueSang();

        request.setAttribute("villes",villes);
        request.setAttribute("donnateurs",donnateurs);
        request.setAttribute("donnationList",donnationList);
        request.setAttribute("gsList",gsList);
        request.setAttribute("banqueSangList",banqueSangList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/listDonnation.jsp");
        requestDispatcher.forward(request,response);
    }
}
