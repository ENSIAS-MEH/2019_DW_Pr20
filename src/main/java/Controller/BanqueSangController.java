package Controller;

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
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println("Servletpath : "+action);
        //action = "/nouveauBanqueForm";
        try {
            switch (action) {
                case "/nouveauBanqueForm":
                    System.out.println("nouveauBanqueform : "+action);
                    nouveauBanqueForm(request, response);
                case "/nouveauBanqueDuSang":
                    System.out.println("nouveauBanqueDuSang : "+action);
                    nouveauBanque(request, response);
                case "/supprimerBanqueDuSang":
                    System.out.println("supprimerBanqueDuSang : "+action);
                    supprimerBanque(request, response);
                case "/modifierBanqueForm":
                    System.out.println("modifierBanqueForm : "+action);
                    modifierBanqueForm(request, response);
                case "/modifierBanqueDuSang":
                    System.out.println("modifierBanqueDuSang : "+action);
                    modifierBanque(request, response);
                default:
                    System.out.println("Default : "+action);
                    listerBanque(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void nouveauBanqueForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp-pkg/nouveau-Banque-Form.jsp");
        request.setAttribute("nombreBanque",banqueSangDAO.countBanqueSang());
        List<Ville> villes = villeDAO.getAllVille();
        request.setAttribute("villes",villes);
        requestDispatcher.forward(request,response);
    }
    private void nouveauBanque(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        String idBanque = request.getParameter("idBanque");
        String nomBanque = request.getParameter("nomBanque");
        String emailBanque = request.getParameter("emailBanque");
        String telebanque = request.getParameter("telebanque");
        String passwordBanque = request.getParameter("passwordBanque");
        String adresseBanque = request.getParameter("adresseBanque");
        String idville = request.getParameter("idVille");
        BanqueSang banqueSang = new BanqueSang();
        banqueSang.setTeleBS(telebanque);
        banqueSang.setPasswordBS(passwordBanque);
        banqueSang.setNomBS(nomBanque);
        banqueSang.setEmailBS(emailBanque);
        banqueSang.setAdresseBS(adresseBanque);
        banqueSang.setIdBS(Integer.parseInt(idBanque));
        banqueSang.setIdVille(Integer.parseInt(idville));
        banqueSangDAO.ajouterBanqueSang(banqueSang);
        response.sendRedirect("list-banque.jsp");


    }

    private void supprimerBanque(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        int idBanque = Integer.parseInt(request.getParameter("idBanque"));
        banqueSangDAO.deleteBanqueSang(idBanque);
    }

    private void modifierBanqueForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        int idBanque = Integer.parseInt(request.getParameter("idBanque"));
        BanqueSang banqueSangExist = banqueSangDAO.findBanqueSangById(idBanque);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp-pkg/nouveau-Banque-Form.jsp");
        request.setAttribute("banqueSangExist",banqueSangExist);
        List<Ville> villes = villeDAO.getAllVille();
        request.setAttribute("villes",villes);
        requestDispatcher.forward(request,response);
    }
    private void modifierBanque(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        int idBanque = Integer.parseInt(request.getParameter("idBanque"));
        String nomBanque = request.getParameter("nomBanque");
        String emailBanque = request.getParameter("emailBanque");
        String telebanque = request.getParameter("telebanque");
        String passwordBanque = request.getParameter("passwordBanque");
        String adresseBanque = request.getParameter("adresseBanque");
        String idville = request.getParameter("idVille");
        BanqueSang banqueSang = new BanqueSang();
        banqueSang.setTeleBS(telebanque);
        banqueSang.setPasswordBS(passwordBanque);
        banqueSang.setNomBS(nomBanque);
        banqueSang.setEmailBS(emailBanque);
        banqueSang.setAdresseBS(adresseBanque);
        banqueSang.setIdBS(idBanque);
        banqueSang.setIdVille(Integer.parseInt(idville));
        banqueSangDAO.updateBanqueSang(banqueSang);
        response.sendRedirect("list-banque.jsp");

    }

    private void listerBanque(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        List<BanqueSang> banqueSangList = banqueSangDAO.findAllBanqueSang();
        List<Ville> villes = villeDAO.getAllVille();
        request.setAttribute("villes",villes);
        request.setAttribute("banqueSangList",banqueSangList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp-pkg/list-banque.jsp");
        requestDispatcher.forward(request,response);
    }

}
