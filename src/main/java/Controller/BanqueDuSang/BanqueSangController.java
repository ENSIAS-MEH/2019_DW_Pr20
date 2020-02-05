package Controller.BanqueDuSang;

import DAO.DAOFactory;
import DAO.interfaces.BanqueSangDAO;
import DAO.interfaces.VilleDAO;
import Model.BanqueSang;
import Model.Ville;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/LesBaqnuesDuSang")
public class BanqueSangController extends HttpServlet {
    private BanqueSangDAO banqueSangDAO;
    private VilleDAO villeDAO;
    private DAOFactory daoFactory = new DAOFactory("jdbc:mysql://localhost:3306/sang","root","");
    private HttpSession httpSession;

    @Override
    public void init() throws ServletException {

        daoFactory.getInstance();
        //System.out.println("good : "+daoFactory);
        banqueSangDAO = daoFactory.getBanqueSangDaoImpl();
        villeDAO = daoFactory.getVilleDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int banqueid = Integer.parseInt(request.getParameter("idBS"));
        if(banqueid == -1) {
            try {
                nouveauBanque(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                modifierBanque(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BanqueSang> banqueSangList = banqueSangDAO.findAllBanqueSang();
        List<Ville> villes = villeDAO.getAllVille();
        request.setAttribute("villes",villes);
        request.setAttribute("banqueSangList",banqueSangList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/list-banque.jsp");
        requestDispatcher.forward(request,response);
    }

    private void nouveauBanque(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        //String idBanque = request.getParameter("idBanque");
        String nomBanque = request.getParameter("ajnomBS");
        String emailBanque = request.getParameter("ajemailBS");
        String telebanque = request.getParameter("ajteleBS");
        String passwordBanque = request.getParameter("ajpasswordBS");
        String adresseBanque = request.getParameter("ajadresseBS");
        String idville = request.getParameter("ajidVille");
        BanqueSang banqueSang = new BanqueSang();
        banqueSang.setTeleBS(telebanque);
        banqueSang.setPasswordBS(passwordBanque);
        banqueSang.setNomBS(nomBanque);
        banqueSang.setEmailBS(emailBanque);
        banqueSang.setAdresseBS(adresseBanque);
        banqueSang.setIdVille(Integer.parseInt(idville));
        banqueSangDAO.ajouterBanqueSang(banqueSang);
        response.sendRedirect("LesBanquesDuSang");

    }

    private void modifierBanque(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        int idBanque = Integer.parseInt(request.getParameter("idBS"));
        String nomBanque = request.getParameter("modnomBS");
        String emailBanque = request.getParameter("modemailBS");
        String telebanque = request.getParameter("modteleBS");
        String passwordBanque = request.getParameter("modpasswordBS");
        String adresseBanque = request.getParameter("modadresseBS");
        String idville = request.getParameter("modidVille");
        BanqueSang banqueSang = new BanqueSang();
        banqueSang.setTeleBS(telebanque);
        banqueSang.setPasswordBS(passwordBanque);
        banqueSang.setNomBS(nomBanque);
        banqueSang.setEmailBS(emailBanque);
        banqueSang.setAdresseBS(adresseBanque);
        //System.out.println(adresseBanque);
        banqueSang.setIdBS(idBanque);
        System.out.println(Integer.parseInt(idville));
        banqueSang.setIdVille(Integer.parseInt(idville));

        banqueSangDAO.updateBanqueSang(banqueSang);
        response.sendRedirect("LesBanquesDuSang");
    }

}
