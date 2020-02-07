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

@WebServlet("/ModifierConvoi")
public class ModifierConvoiServlet extends HttpServlet {

    private DAOFactory daoFactory;
    private ConvoiDAO convoiDao;

    @Override
    public void init() throws ServletException {
        super.init();
        daoFactory = DAOFactory.getInstance();
        convoiDao = daoFactory.getConvoiDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if(session.getAttribute("banquesang")==null){
            response.sendRedirect("SignIn");
        }
        else {
            try {
                modifierConvoi(request,response);
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("Convois");

    }

    private void modifierConvoi(HttpServletRequest request, HttpServletResponse response)  throws SQLException, IOException, ServletException{
        int id = Integer.parseInt(request.getParameter("id"));
        String titreConvoi = request.getParameter("titreConvoi");
        String description = request.getParameter("description");

        HttpSession session = request.getSession();
        BanqueSang banqueSang = (BanqueSang) session.getAttribute("banquesang");

        Convoi convoi = new Convoi();
        convoi.setIdConvoi(id);
        convoi.setTitreConvoi(titreConvoi);
        convoi.setDescription(description);
        convoi.setIdBS(banqueSang.getIdBS());
        //convoi.setIdBS(1);
        convoiDao.updateConvoi(convoi);
        response.sendRedirect("Convois");
    }
}
