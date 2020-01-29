package Controller.Convoi;

import DAO.DAOFactory;
import DAO.interfaces.BanqueSangDAO;
import DAO.interfaces.ConvoiDAO;
import Model.BanqueSang;
import Model.Convoi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/Convois")
public class ConvoiServlet extends HttpServlet {

    private DAOFactory daoFactory;
    private ConvoiDAO convoiDao;
    private BanqueSangDAO banqueSangDAO;


    @Override
    public void init() throws ServletException {
        super.init();
        daoFactory = DAOFactory.getInstance();
        convoiDao = daoFactory.getConvoiDaoImpl();
        banqueSangDAO = daoFactory.getBanqueSangDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.init();
        /*
        HttpSession session = request.getSession();
        if(session.getAttribute("BanqueSang")==null){
            response.sendRedirect("/jsp/login.jsp");
        }else {

        }
        */
        String action = request.getServletPath();
        System.out.println(action);


        try{
            listConvoi(request, response);
            /*
            switch (action){
                case "/Convois":
                    listConvoi(request,response);
                    break;
                case "/supprimerConvoi":
                    supprimerConvoi(request,response);
                    break;


            }
             */
        }catch (SQLException ex){
            throw new ServletException(ex);
        }

    }

    private void listConvoi(HttpServletRequest request , HttpServletResponse response) throws SQLException, IOException, ServletException{
        List<BanqueSang> banqueSangs = banqueSangDAO.findAllBanqueSang();
        List<Convoi> convois = convoiDao.allConvoi();
        request.setAttribute("convois",convois);
        request.setAttribute("banques",banqueSangs);
        this.getServletContext().getRequestDispatcher("/jsp/list-convois.jsp").forward(request, response);

    }

    private void insertConvoi(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String titreConvoi = request.getParameter("titreConvoi");
        String description = request.getParameter("description");

        System.out.println(titreConvoi + " "+ description);

        //BanqueSang banqueSang = (BanqueSang) session.getAttribute("BanqueSang");

        Convoi convoi = new Convoi();
        convoi.setTitreConvoi(titreConvoi);
        convoi.setDescription(description);
        //convoi.setIdBS(banqueSang.getIdBS());
        convoi.setIdBS(1);
        convoiDao.addConvoi(convoi);
        response.sendRedirect("Convois");
    }



}
