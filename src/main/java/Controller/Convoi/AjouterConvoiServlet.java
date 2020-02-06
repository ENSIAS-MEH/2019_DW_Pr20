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
import java.sql.SQLException;
import java.util.List;
@WebServlet("/AjouterConvoi")
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

        HttpSession session = request.getSession();
        if(session.getAttribute("banquesang")==null){
            response.sendRedirect("SignIn");
        }else {
            response.sendRedirect("Convois");

        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if(session.getAttribute("banquesang")==null){
            response.sendRedirect("SignIn");
        }
        else {
            try {
                insertConvoi(request, response);
            } catch (SQLException ex) {
                throw new ServletException(ex);

            }
        }


    }

    private void insertConvoi(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String titreConvoi = request.getParameter("titreConvoi");
        String description = request.getParameter("description");

        HttpSession session = request.getSession();
        BanqueSang banqueSang = (BanqueSang) session.getAttribute("BanqueSang");

        Convoi convoi = new Convoi();
        convoi.setTitreConvoi(titreConvoi);
        convoi.setDescription(description);
        convoi.setIdBS(banqueSang.getIdBS());
        //convoi.setIdBS(1);
        convoiDao.addConvoi(convoi);
        response.sendRedirect("Convois");
    }
}
