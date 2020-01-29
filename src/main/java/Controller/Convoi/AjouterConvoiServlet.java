package Controller.Convoi;

import DAO.DAOFactory;
import DAO.interfaces.ConvoiDAO;
import Model.BanqueSang;
import Model.Convoi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class AjouterConvoiServlet extends HttpServlet {

    private DAOFactory daoFactory;
    ConvoiDAO convoiDao;

    @Override
    public void init() throws ServletException {
        super.init();
        daoFactory = DAOFactory.getInstance();
        convoiDao = daoFactory.getConvoiDaoImpl();
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

            this.getServletContext().getRequestDispatcher("/jsp/addConvoi.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if(session.getAttribute("BanqueSang")==null){
            response.sendRedirect("/jsp/login.jsp");
        }
        else {
        }


            String titreConvoi = request.getParameter("titreConvoi");
            String description = request.getParameter("description");

            System.out.println(titreConvoi + " "+ description);

            BanqueSang banqueSang = (BanqueSang) session.getAttribute("BanqueSang");

            Convoi convoi = new Convoi();
            convoi.setTitreConvoi(titreConvoi);
            convoi.setDescription(description);
            convoi.setIdBS(banqueSang.getIdBS());

            convoiDao.addConvoi(convoi);
            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);

    }

}
