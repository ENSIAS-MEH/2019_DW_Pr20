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
import java.util.ArrayList;
import java.util.List;

public class AdminStatistics extends HttpServlet {

    private BanqueSangDAO banqueSangDAO;
    private VilleDAO villeDAO;
    private DAOFactory daoFactory = new DAOFactory("jdbc:mysql://localhost:3306/sang","root","");
    private HttpSession httpSession;
    private StockSangDAO stockSangDAO;
    private GroupeSanginDAO groupeSanginDAO;
    private int idBS = 9; /*Depuis la Sessions : Never Used*/

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

            if(ville.equals("all") && bq.equals("all")){
                System.out.println("case 0");
                response.getWriter().write(allStats().toString());
            }
            else if(!ville.equals("all") && bq.equals("all")){
                response.getWriter().write(statsByVille(Integer.parseInt(ville)).toString());
                System.out.println(statsByVille(Integer.parseInt(ville)).toString());
            }
            else if(ville.equals("all") && !bq.equals("all")){
                response.getWriter().write(statsByBanq(Integer.parseInt(bq)).toString());
            }
            else if(!ville.equals("all") && !bq.equals("all")){
                response.getWriter().write(statsBoth(Integer.parseInt(bq)).toString());
            }
        }
        else if(request.getParameter("action").equals("load_bq")){
            int ville = Integer.parseInt(request.getParameter("ville"));
            List<BanqueSang> bqList = banqueSangDAO.findBanquesByVille(ville);
            System.out.println(banqtoJSON(bqList));
            response.getWriter().write(banqtoJSON(bqList));
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        int idGroup = Integer.parseInt(request.getParameter("id"));
        StockSang stockSang  = stockSangDAO.findStockById(idBS,idGroup);
        int quantite = Integer.parseInt(request.getParameter("quantite"));
        stockSang.setQuantite(quantite);
        stockSangDAO.updateStockSang(stockSang);
        this.init();
        this.doGet(request,response);
    }

    private String banqtoJSON(List<BanqueSang> bqList) {

        StringBuffer banqRow = new StringBuffer("{\"idBS\":[");

        boolean flag = false;
        for (BanqueSang b : bqList) {
            if (flag)
                banqRow.append(",");
            flag = true;
            banqRow.append("\"" + b.getIdBS() + "\"");
        }

        banqRow.append("],\"nomBS\":[");
        flag = false;
        for (BanqueSang b : bqList) {
            if (flag)
                banqRow.append(",");
            flag = true;
            banqRow.append("\"" + b.getNomBS()+ "\"");
        }

        banqRow.append("]}");
        return banqRow.toString();
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

}
