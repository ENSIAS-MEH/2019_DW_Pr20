package Controller.AlerteBesoin;

import DAO.DAOFactory;
import DAO.Implementation.BanqueSangDaoImpl;
import DAO.Implementation.DonnateurDaoImpl;
import DAO.Implementation.GroupeSanginDaoImpl;
import DAO.interfaces.AlerteBesoinDAO;
import DAO.interfaces.BanqueSangDAO;
import DAO.interfaces.GroupeSanginDAO;
import Model.*;
import DAO.interfaces.VilleDAO;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import util.SendSMS;
import util.TwitterAlerte;
import util.TwitterMethods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AlerteBesoinServlet extends HttpServlet {
    private DAOFactory daoFactory;
    private AlerteBesoinDAO alerteBesoinDAO;
    private GroupeSanginDAO groupeSanginDAO;
    private VilleDAO villeDAO;

    private List<AlerteBesoin> alertes;
    private List<GroupeSangin> groupes;
    private List<Ville> villes;

    @Override
    public void init() throws ServletException {
        super.init();
        daoFactory = DAOFactory.getInstance();
        alerteBesoinDAO = daoFactory.getAlerteBesoinDaoImpl();
        groupeSanginDAO = daoFactory.getGroupeSanginDaoImpl();
        villeDAO = daoFactory.getVilleDaoImpl();

        alertes = alerteBesoinDAO.getAlerteByBS(1);
        groupes = groupeSanginDAO.findAll();
        villes = villeDAO.getAllVille();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.init();
        request.setAttribute("alertes", alertes);
        request.setAttribute("villes",villes);
        request.setAttribute("groupes",groupes);
        this.getServletContext().getRequestDispatcher("/jsp/alertes.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String g=request.getParameter("groupesangin");
        String d=request.getParameter("desc");
        String message = "";
        GroupeSanginDaoImpl groupeSanginDao =new GroupeSanginDaoImpl(DAOFactory.getInstance());
        DonnateurDaoImpl donnateurDao =new DonnateurDaoImpl(DAOFactory.getInstance());
        BanqueSangDaoImpl banqueSangDao =new BanqueSangDaoImpl(DAOFactory.getInstance());
        List<Donnateur> donnateurs = donnateurDao.getAllDonnateurs();
        int grp = Integer.parseInt(g);
        if(grp !=-1 && !d.equals("")){
            GroupeSangin G = new GroupeSangin(grp,"");
            AlerteBesoin ab = new AlerteBesoin();
            ab.setGS(G);
            ab.setDescriptionAlerte(d);
            ab.setIdBS(1);
            alerteBesoinDAO.addAlerte(ab);
                Thread sms = new SendSMS(donnateurs,"Une Alerte est lancée. C'est urgent !! "+"Banque du Sang : "
                        +banqueSangDao.findBanqueSangById(ab.getIdBS()).getNomBS()+" Adresse : "+banqueSangDao.findBanqueSangById(ab.getIdBS()).getAdresseBS()+" Groupe sangin : "
                        +groupeSanginDao.findGroupSanginById(ab.getGS().getIdGS()).getNomGS()+"<br><br><b>Description de l'alerte :</b> "+ab.getDescriptionAlerte());
                sms.start();

        }
        this.init();
        this.doGet(request,response);
    }
}
