package Controller.BanqueDuSang;

import DAO.DAOFactory;
import DAO.interfaces.BanqueSangDAO;
import DAO.interfaces.VilleDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class SupprimerBanqueController extends HttpServlet {
    private BanqueSangDAO banqueSangDAO;
    private DAOFactory daoFactory = new DAOFactory("jdbc:mysql://localhost:3306/sang","root","");
    private HttpSession httpSession;

    @Override
    public void init()
    {
        daoFactory.getInstance();
        banqueSangDAO = daoFactory.getBanqueSangDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/LesBanquesDuSang");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            supprimerBanque(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/LesBanquesDuSang");
    }

    private void supprimerBanque(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        int idBanque = Integer.parseInt(request.getParameter("id"));
        banqueSangDAO.deleteBanqueSang(idBanque);
    }


}
