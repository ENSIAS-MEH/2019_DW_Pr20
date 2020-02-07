package Controller;

import DAO.DAOFactory;
import DAO.interfaces.*;
import Model.*;

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
    private DonnationDAO donnationDAO;
    private DonnateurDAO donnateurDAO;
    private GroupeSanginDAO groupeSanginDAO;

    @Override
    public void init() throws ServletException {

        daoFactory.getInstance();
        banqueSangDAO = daoFactory.getBanqueSangDaoImpl();
        villeDAO = daoFactory.getVilleDaoImpl();
        donnationDAO = daoFactory.getDonnationDaoImpl();
        donnateurDAO = daoFactory.getDonnateurDaoImpl();
        groupeSanginDAO = daoFactory.getGroupeSanginDaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("action").equals("dnt_stat")){

            List<Integer> stats = new ArrayList<>();
            HttpSession session = request.getSession(false);
            String role = (String)session.getAttribute("role");

            if(role.equals("admin")){
                for(int i=1; i<9; i++)
                    stats.add(donnationDAO.DonnationsNbrPerGS(i));
            }
            else if(role.equals("banquesang")){
                BanqueSang bq = (BanqueSang)session.getAttribute("banquesang");
                for(int i=1; i<9; i++)
                    stats.add(donnationDAO.DonnationsNbrPerGS(i, bq.getIdBS()));
            }

            response.getWriter().write(stats.toString());
        }
        else if(request.getParameter("action").equals("load_dnt")){

            int idD = Integer.parseInt(request.getParameter("idD"));
            Donnateur d = donnateurDAO.getDonnateurById(idD);

            if(d == null)
                response.getWriter().write("notfound");
            else{
                int nbrd = donnateurDAO.donnationLastM(d.getIdDonnateur());         //donations nbr last 3 mounths
                if(nbrd == 0)
                    response.getWriter().write(donnateurtoJSON(d));
                else
                    response.getWriter().write("lastmonths");
            }
        }
    }

    private String donnateurtoJSON(Donnateur d) {
        String nom = d.getNomD() + " " + d.getPrenomD();
        String gs = groupeSanginDAO.findGroupSanginById(d.getIdGS()).getNomGS();

        return "{\"pnomD\":\""+nom+"\",\"gs\":\""+gs+"\"}";
    }
}
