package Controller;

import DAO.DAOFactory;
import DAO.interfaces.BanqueSangDAO;
import DAO.interfaces.GroupeSanginDAO;
import DAO.interfaces.StockSangDAO;
import DAO.interfaces.VilleDAO;
import Model.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AdminStatistics extends HttpServlet {

    private BanqueSangDAO banqueSangDAO;
    private VilleDAO villeDAO;
    private DAOFactory daoFactory = new DAOFactory("jdbc:mysql://localhost:3306/sang","root","");
    private HttpSession httpSession;
    private StockSangDAO stockSangDAO;
    private GroupeSanginDAO groupeSanginDAO;
    private int idBS = 9; /*Depuis la Sessions*/

    @Override
    public void init() throws ServletException  {

        daoFactory.getInstance();
        banqueSangDAO = daoFactory.getBanqueSangDaoImpl();
        villeDAO = daoFactory.getVilleDaoImpl();
        stockSangDAO = daoFactory.getStockSangDaoImpl();
        groupeSanginDAO = daoFactory.getGroupeSanginDaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("action") == null || request.getParameter("action").equals("")){
            List<StockSang> stockSangList = new ArrayList<StockSang>();
            stockSangList= stockSangDAO.findStockByBanqueSang(idBS);   /*Id depuis la Session Aprés*/
            List<GroupeSangin> groupeSanginList = groupeSanginDAO.findAll();
            BanqueSang currentBanque = banqueSangDAO.findBanqueSangById(idBS);  /*Id depuis la Session Aprés*/
            List<Ville> villes = villeDAO.getAllVille();
            List<BanqueSang> banqueSangList = banqueSangDAO.findAllBanqueSang();
            ArrayList<Integer> allStock = (ArrayList<Integer>) stockSangDAO.AllstocStatistic();
            System.out.println("All Stock ;"+allStock);

            request.setAttribute("allStock",allStock);
            request.setAttribute("villes",villes);
            request.setAttribute("banqueSangList",banqueSangList);
            request.setAttribute("groupList",groupeSanginList);
            request.setAttribute("currentBanque",currentBanque);
            request.setAttribute("stockList",stockSangList);
            this.getServletContext().getRequestDispatcher("/jsp/AdminStockStatistics.jsp").forward(request,response);
        }
        else if(request.getParameter("action").equals("filter")){
            String ville = request.getParameter("ville").trim();
            String bq = request.getParameter("banq").trim();
            System.out.println(request.getParameter("action").equals("filter"));
            System.out.println(ville +" ----- "+bq);

            if(ville.equals("all") && bq.equals("all")){
                System.out.println("case 0");
                response.getWriter().write(allStats().toString());
            }
            else if(!ville.equals("all") && bq.equals("all")){
                System.out.println("case 1");
                response.getWriter().write(statsByVille(Integer.parseInt(ville)).toString());
                System.out.println(statsByVille(Integer.parseInt(ville)).toString());
            }
            else if(ville.equals("all") && !bq.equals("all")){
                System.out.println("case 2");
                response.getWriter().write(statsByBanq(Integer.parseInt(bq)).toString());
                System.out.println(statsByBanq(Integer.parseInt(bq)).toString());
            }
            else if(!ville.equals("all") && !bq.equals("all")){
                System.out.println("case 3");
                response.getWriter().write(statsBoth(Integer.parseInt(bq)).toString());
                System.out.println(statsBoth(Integer.parseInt(bq)).toString());
            }
        }

        //System.out.println("From statistics");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
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

    private List<Integer> allStats() {
        List<Integer>  statList =  stockSangDAO.AllstocStatistic();
        return  statList;
    }

    private List<Integer> statsByVille(int idVille) {
        List<Integer>  statList =  stockSangDAO.statsByVille(idVille);
        return statList;
    }

    private List<Integer> statsByBanq(int idBnq) {
        List<Integer>  statList =  stockSangDAO.statsByBanque(idBnq);
        return statList;
    }

    private List<Integer> statsBoth(int idBnq) {
        List<Integer>  statList =  stockSangDAO.statsByBanque(idBnq);
        return statList;
    }

    /*private String donnationtoJSON(List<Donnation> donnList) {

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
    }*/


}
