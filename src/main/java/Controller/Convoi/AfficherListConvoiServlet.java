package Controller.Convoi;

import DAO.DAOFactory;
import DAO.interfaces.ConvoiDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AfficherListConvoiServlet extends HttpServlet {

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
        this.getServletContext().getRequestDispatcher("/jsp/afficherConvois.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
