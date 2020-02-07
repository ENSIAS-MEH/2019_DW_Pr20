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
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/Donnateur")
public class DonnateurController extends HttpServlet {
    private DAOFactory daoFactory = new DAOFactory("jdbc:mysql://localhost:3306/sang", "root", "");
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost..");
        if (request.getParameter("action").equals("ajouter")) {
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String cin = request.getParameter("cin");
            String email = request.getParameter("email");
            String tel = request.getParameter("tel");
            String passwd = nom +"10";
            int gs = Integer.parseInt(request.getParameter("gs"));
            int ville = Integer.parseInt(request.getParameter("ville"));

            Donnateur d = new Donnateur(cin, nom, prenom, tel, email, passwd, ville, gs);
            System.out.println("avant");
            Boolean res = donnateurDAO.addDonnateur(d);
            System.out.println("result add : " + res);
            response.getWriter().write(res.toString());
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet..");
        if (request.getParameter("action") == null || request.getParameter("action").equals("")) {
            try {
                System.out.println("tata");
                showDonnateurs(request, response);
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }
        }
        else if (request.getParameter("action").equals("filter")) {
            System.out.println("filter");
            String gs = request.getParameter("gs").trim();
            String ville = request.getParameter("ville").trim();
            response.setContentType("application/json");

            if (gs.equals("all") && ville.equals("all")) {
                System.out.println(allDonnateurs());
                response.getWriter().write(allDonnateurs());
            } else if (!gs.equals("all") && ville.equals("all")) {
                System.out.println(filterByGs(gs));
                response.getWriter().write(filterByGs(gs));
            } else if (gs.equals("all") && !ville.equals("all")) {
                System.out.println(filterByVille(ville));
                response.getWriter().write(filterByVille(ville));
            } else if (!gs.equals("all") && !ville.equals("all")) {
                System.out.println(filterByBoth(ville, gs));
                response.getWriter().write(filterByBoth(ville, gs));
            }
        }

    }

    private void showDonnateurs(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        List<Ville> villes = villeDAO.getAllVille();
        List<Donnateur> donnateurs = donnateurDAO.getAllDonnateurs();
        List<GroupeSangin> gsList = groupeSanginDAO.findAll();
        request.setAttribute("villes", villes);
        request.setAttribute("donnateurs", donnateurs);
        request.setAttribute("gsList", gsList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/listDonnateur.jsp");
        requestDispatcher.forward(request, response);
    }

    private String allDonnateurs() {

        List<Donnateur> donnateurList = donnateurDAO.getAllDonnateurs();
        return donnateurtoJSON(donnateurList);
    }

    private String filterByGs(String gs) {
        int idGS = groupeSanginDAO.findGroupSanginByName(gs).getIdGS();
        List<Donnateur> donnateurList = donnateurDAO.getDonnateursByGrpSg(idGS);
        return donnateurtoJSON(donnateurList);
    }

    private String filterByVille(String ville) {

        int idVille = villeDAO.getVilleByName(ville).getIdVille();
        List<Donnateur> donnateurList = donnateurDAO.getDonnateursByCity(idVille);

        return donnateurtoJSON(donnateurList);
    }

    private String filterByBoth(String ville, String gs) {
        int idVille = villeDAO.getVilleByName(ville).getIdVille();
        int idGS = groupeSanginDAO.findGroupSanginByName(gs).getIdGS();

        List<Donnateur> donnateurList = donnateurDAO.getAllDonnateursVilleGS(idVille, idGS);
        return donnateurtoJSON(donnateurList);
    }

    private String donnateurtoJSON(List<Donnateur> donnList) {

        StringBuffer donnateurRow = new StringBuffer("{\"idDonnateur\":[");

        boolean flag = false;
        for (Donnateur d : donnList) {
            if (flag)
                donnateurRow.append(",");
            flag = true;
            donnateurRow.append("\"" + d.getIdDonnateur() + "\"");
        }

        donnateurRow.append("],\"cin\":[");
        flag = false;
        for (Donnateur d : donnList) {
            if (flag)
                donnateurRow.append(",");
            flag = true;
            donnateurRow.append("\"" + d.getCin() + "\"");
        }

        donnateurRow.append("],\"pnomD\":[");
        flag = false;
        for (Donnateur d : donnList) {
            if (flag)
                donnateurRow.append(",");
            flag = true;
            donnateurRow.append("\"" + d.getNomD() + " " + d.getPrenomD() + "\"");
        }

        donnateurRow.append("],\"gs\":[");
        flag = false;
        for (Donnateur d : donnList) {
            if (flag)
                donnateurRow.append(",");
            flag = true;
            donnateurRow.append("\"" + groupeSanginDAO.findGroupSanginById(d.getIdGS()).getNomGS() + "\"");
        }

        donnateurRow.append("],\"telD\":[");
        flag = false;
        for (Donnateur d : donnList) {
            if (flag)
                donnateurRow.append(",");
            flag = true;
            donnateurRow.append("\"" + d.getTeleD() + "\"");
        }

        donnateurRow.append("],\"ville\":[");
        flag = false;
        for (Donnateur d : donnList) {
            if (flag)
                donnateurRow.append(",");
            flag = true;
            donnateurRow.append("\"" + villeDAO.getVilleById(d.getIdVille()).getNomVille() + "\"");
        }

        donnateurRow.append("]}");
        return donnateurRow.toString();
    }

}
