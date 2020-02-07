package Controller;

import DAO.DAOFactory;
import DAO.interfaces.BanqueSangDAO;
import DAO.interfaces.DonnateurDAO;
import Model.Admin;
import Model.BanqueSang;
import Model.Donnateur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class AuthenticationServlet extends HttpServlet {
    private DAOFactory daoFactory;
    private DonnateurDAO donnateurDAO;
    private BanqueSangDAO banqueSangDAO;

    private Admin admin;
    private BanqueSang banqueSang;
    private Donnateur donnateur;

    @Override
    public void init() throws ServletException {
        super.init();
        daoFactory = DAOFactory.getInstance();
        donnateurDAO = daoFactory.getDonnateurDaoImpl();
        banqueSangDAO = daoFactory.getBanqueSangDaoImpl();

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mail = request.getParameter("username");
        String pass = request.getParameter("password");

        admin = banqueSangDAO.getAdmin(mail,pass);
        banqueSang = banqueSangDAO.findBanqueSang(mail,pass);
        donnateur = donnateurDAO.getDonnateur(mail,pass);

        if(admin == null && banqueSang==null && donnateur==null){
            request.setAttribute("error","Unsername or Password are incorrects");
            this.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }
        else{
            if(admin != null){
                HttpSession session = request.getSession();
                session.setAttribute("role", "admin");
                session.setAttribute("admin", admin);
                System.out.println("role : "+session.getAttribute("role") + "\n"+admin);

                response.sendRedirect("/AdminStatistiques");
            }
            else if(banqueSang != null){
                HttpSession session = request.getSession();
                session.setAttribute("role", "banquesang");
                session.setAttribute("banquesang", banqueSang);
                System.out.println("role : "+session.getAttribute("role") + "\n"+banqueSang);
                response.sendRedirect("/Statistiques");
            }
            else if(donnateur != null){
                HttpSession session = request.getSession();
                session.setAttribute("role", "donnateur");
                session.setAttribute("donnateur", donnateur);
                System.out.println("role : "+session.getAttribute("role") + "\n"+donnateur);
                response.sendRedirect("/Donnation");
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.init();
        HttpSession session = request.getSession();
        session=request.getSession();
        Admin ad=(Admin) session.getAttribute("admin");
        BanqueSang bs=(BanqueSang) session.getAttribute("banquesang");
        Donnateur dn=(Donnateur) session.getAttribute("donnateur");

        if(ad!=null){
            response.sendRedirect("/AdminStatistiques");
        }

        else if(bs!=null) {
            response.sendRedirect("/Statistiques");
        }

        else if(dn!=null){
            response.sendRedirect("/Donnation");
        }
        else {
            this.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }
    }
}
