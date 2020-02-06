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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/Donnation")
public class DonnationController extends HttpServlet {
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
        System.out.println("doPost");
        if (request.getParameter("action").equals("ajouter")) {
            int idDonnateur = Integer.parseInt(request.getParameter("idD"));
            int idBS = Integer.parseInt(request.getParameter("idBS"));

            Boolean res = donnationDAO.addDonnation(idDonnateur, idBS);
            System.out.println("result add : " + res);
            response.getWriter().write(res.toString());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet");
        if (request.getParameter("action") == null || request.getParameter("action").equals("")) {
            try {
                showDonnations(request, response);
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }
        } else if (request.getParameter("action").equals("filter")) {
            String gs = request.getParameter("gs").trim();
            String ville = request.getParameter("ville").trim();
            response.setContentType("application/json");

            if (gs.equals("all") && ville.equals("all")) {
                response.getWriter().write(allDonnations());
            } else if (!gs.equals("all") && ville.equals("all")) {
                response.getWriter().write(filterByGs(gs));
            } else if (gs.equals("all") && !ville.equals("all")) {
                response.getWriter().write(filterByVille(ville));
            } else if (!gs.equals("all") && !ville.equals("all")) {
                response.getWriter().write(filterByBoth(ville, gs));
            }
        }
    }
/*
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("action").equals("ajouter")){
            System.out.println("dad");
            int idDonnateur = Integer.parseInt(request.getParameter("idD"));
            int idBS = Integer.parseInt(request.getParameter("idBS"));
            Timestamp dateDonnation = Timestamp.valueOf(request.getParameter("dateD"));

            Donnation d = new Donnation(idDonnateur, idBS, dateDonnation);
            Boolean res = donnationDAO.addDonnation(d);
            response.getWriter().write(res.toString());
        }
    }*/

    private String donnationtoJSON(List<Donnation> donnList) {

        StringBuffer donnationRow = new StringBuffer("{\"idDonnateur\":[");

        boolean flag = false;
        for (Donnation d : donnList) {
            if (flag)
                donnationRow.append(",");
            flag = true;
            donnationRow.append("\"" + d.getIdDonnateur() + "\"");
        }

        donnationRow.append("],\"pnomD\":[");
        flag = false;
        for (Donnation d : donnList) {
            if (flag)
                donnationRow.append(",");
            flag = true;
            Donnateur donnateur = donnateurDAO.getDonnateurById(d.getIdDonnateur());
            donnationRow.append("\"" + donnateur.getNomD() + " " + donnateur.getPrenomD() + "\"");
        }

        donnationRow.append("],\"telD\":[");
        flag = false;
        for (Donnation d : donnList) {
            if (flag)
                donnationRow.append(",");
            flag = true;
            Donnateur donnateur = donnateurDAO.getDonnateurById(d.getIdDonnateur());
            donnationRow.append("\"" + donnateur.getTeleD() + "\"");
        }

        donnationRow.append("],\"emailD\":[");
        flag = false;
        for (Donnation d : donnList) {
            if (flag)
                donnationRow.append(",");
            flag = true;
            Donnateur donnateur = donnateurDAO.getDonnateurById(d.getIdDonnateur());
            donnationRow.append("\"" + donnateur.getEmailD() + "\"");
        }

        donnationRow.append("],\"gs\":[");
        flag = false;
        for (Donnation d : donnList) {
            if (flag)
                donnationRow.append(",");
            flag = true;
            Donnateur donnateur = donnateurDAO.getDonnateurById(d.getIdDonnateur());
            donnationRow.append("\"" + groupeSanginDAO.findGroupSanginById(donnateur.getIdGS()).getNomGS() + "\"");
        }

        SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        donnationRow.append("],\"dateDonnation\":[");
        flag = false;
        for (Donnation d : donnList) {
            if (flag)
                donnationRow.append(",");
            flag = true;
            String date = date_format.format(d.getDateDonnation());
            donnationRow.append("\"" + date + "\"");
        }

        donnationRow.append("],\"idBS\":[");
        flag = false;
        for (Donnation d : donnList) {
            if (flag)
                donnationRow.append(",");
            flag = true;
            donnationRow.append("\"" + d.getIdBS() + "\"");
        }

        donnationRow.append("],\"nomB\":[");
        flag = false;
        for (Donnation d : donnList) {
            if (flag)
                donnationRow.append(",");
            flag = true;
            BanqueSang banq = banqueSangDAO.findBanqueSangById(d.getIdBS());
            donnationRow.append("\"" + banq.getNomBS() + "\"");
        }

        donnationRow.append("],\"telB\":[");
        flag = false;
        for (Donnation d : donnList) {
            if (flag)
                donnationRow.append(",");
            flag = true;
            BanqueSang banq = banqueSangDAO.findBanqueSangById(d.getIdBS());
            donnationRow.append("\"" + banq.getTeleBS() + "\"");
        }

        donnationRow.append("],\"villeB\":[");
        flag = false;
        for (Donnation d : donnList) {
            if (flag)
                donnationRow.append(",");
            flag = true;
            BanqueSang banq = banqueSangDAO.findBanqueSangById(d.getIdBS());
            donnationRow.append("\"" + villeDAO.getVilleById(banq.getIdVille()).getNomVille() + "\"");
        }

        donnationRow.append("]}");
        return donnationRow.toString();
    }

    private void showDonnations(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        List<Donnation> donnationList = null;

        HttpSession session = request.getSession(false);
        String role = (String) session.getAttribute("role");

        if (role.equals("banquesang")) {
            BanqueSang banq = (BanqueSang) session.getAttribute("banquesang");
            donnationList = donnationDAO.getAllDonnationsBanq(banq.getIdBS());
        } else if (role.equals("donnateur")) {
            Donnateur donnateur = (Donnateur) session.getAttribute("donnateur");
            donnationList = donnationDAO.getAllDonnationsDonnateur(donnateur.getIdDonnateur());
        }

        List<Ville> villes = villeDAO.getAllVille();
        List<Donnateur> donnateurs = donnateurDAO.getAllDonnateurs();
        List<GroupeSangin> gsList = groupeSanginDAO.findAll();
        List<BanqueSang> banqueSangList = banqueSangDAO.findAllBanqueSang();

        request.setAttribute("villes", villes);
        request.setAttribute("donnateurs", donnateurs);
        request.setAttribute("donnationList", donnationList);
        request.setAttribute("gsList", gsList);
        request.setAttribute("banqueSangList", banqueSangList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/listDonnation.jsp");
        requestDispatcher.forward(request, response);
    }

    private String allDonnations() {

        List<Donnation> donnationList = donnationDAO.getAllDennation();
        return donnationtoJSON(donnationList);
    }

    private String filterByGs(String gs) {

        List<Donnation> donnationList = donnationDAO.getAllDonnationsGS(gs);
        return donnationtoJSON(donnationList);
    }

    private String filterByVille(String ville) {

        int idVille = villeDAO.getVilleByName(ville).getIdVille();
        List<Donnation> donnationList = donnationDAO.getAllDonnationsVille(idVille);

        return donnationtoJSON(donnationList);
    }

    private String filterByBoth(String ville, String gs) {
        int idVille = villeDAO.getVilleByName(ville).getIdVille();
        int idGS = groupeSanginDAO.findGroupSanginByName(gs).getIdGS();

        List<Donnation> donnationList = donnationDAO.getAllDonnationsVilleGS(idVille, idGS);
        return donnationtoJSON(donnationList);
    }
}


