package Controller.Convoi;

import DAO.DAOFactory;
import DAO.interfaces.ConvoiDAO;
import Model.Convoi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/supprimerConvoi")
public class SupprimerConvoiServlet extends HttpServlet {

    private DAOFactory daoFactory;
    private ConvoiDAO convoiDao;

    @Override
    public void init() throws ServletException {
        super.init();
        daoFactory = DAOFactory.getInstance();
        convoiDao = daoFactory.getConvoiDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.init();

        HttpSession session = request.getSession();
        if(session.getAttribute("banquesang")==null){
            response.sendRedirect("SignIn");
        }else {
            try {
                supprimerConvoi(request,response);
            } catch (SQLException e) {
                throw new ServletException(e);
            }
        }



    }

    private void supprimerConvoi(HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Convoi convoi = new Convoi();
        convoi.setIdConvoi(id);
        convoiDao.deleteConvoi(convoi);
        response.sendRedirect("Convois");
    }
}
