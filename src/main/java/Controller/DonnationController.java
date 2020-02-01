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
        //doGet(request, response);
        String action = request.getParameter("action").trim();

        System.out.println(action.equals("filt"));
        if(action.equals("filt")){
            String gs = request.getParameter("gs").trim();
            String ville = request.getParameter("ville").trim();

            if(gs.equals("all") && ville.equals("all")){
                System.out.println("case 0");
                allDonnations();
            }
            else if(!gs.equals("all") && ville.equals("all")){
                System.out.println("case 1");
                filterByGs(gs);
            }
            else if(gs.equals("all") && !ville.equals("all")){
                System.out.println("case 2");
                filterByVille(ville);
            }
            else if(!gs.equals("all") && !ville.equals("all")){
                System.out.println("case 3");
                filterByBoth(ville, gs);
            }
        }
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

    private void allDonnations(){

        List<Donnation> donnationList = donnationDAO.getAllDennation();

        JsonConverter converter = new JsonConverter();
        String output = converter.convertToJson(donnationList);
    }

    private void filterByGs(String gs){

        List<Donnation> donnationList = donnationDAO.getAllDonnationsGS(gs);
        System.out.println(donnationList.toString());
        JsonConverter converter = new JsonConverter();
        String output = converter.convertToJson(donnationList);
    }

    private void filterByVille(String ville){
        int idVille = villeDAO.getVilleByName(ville).getIdVille();
        List<Donnation> donnationList = donnationDAO.getAllDonnationsVille(idVille);

        JsonConverter converter = new JsonConverter();
        String output = converter.convertToJson(donnationList);

    }

    private void filterByBoth(String ville, String gs){
        int idVille = villeDAO.getVilleByName(ville).getIdVille();
        int idGS = groupeSanginDAO.findGroupSanginByName(gs).getIdGS();

        List<Donnation> donnationList = donnationDAO.getAllDonnationsVilleGS(idVille, idGS);

        JsonConverter converter = new JsonConverter();
        String output = converter.convertToJson(donnationList);
    }
}
