package Controller.AlerteBesoin;

import DAO.DAOFactory;
import DAO.interfaces.AlerteBesoinDAO;
import DAO.interfaces.GroupeSanginDAO;
import DAO.interfaces.VilleDAO;
import Model.AlerteBesoin;
import Model.GroupeSangin;
import Model.Ville;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TraiterServlet")
public class TraiterServlet extends HttpServlet {
    private DAOFactory daoFactory;
    private AlerteBesoinDAO alerteBesoinDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        daoFactory = DAOFactory.getInstance();
        alerteBesoinDAO = daoFactory.getAlerteBesoinDaoImpl();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/Alertes");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String d = request.getParameter("d");
        String s = request.getParameter("s");
        if(d != null){
            alerteBesoinDAO.disableAlerte(Integer.parseInt(d));
        }
        if(s != null){
            alerteBesoinDAO.deleteAlerte(Integer.parseInt(s));
        }
        response.sendRedirect("/Alertes");
    }
}
