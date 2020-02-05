package Controller;

import DAO.DAOFactory;
import DAO.interfaces.*;
import Model.Donnation;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet("/DonnActions")
public class DonnationTrait extends HttpServlet {
    private DAOFactory daoFactory = new DAOFactory("jdbc:mysql://localhost:3306/sang","root","");
    private HttpSession httpSession;

    private DonnationDAO donnationDAO;
    private DonnateurDAO donnateurDAO;
    private VilleDAO villeDAO;
    private GroupeSanginDAO groupeSanginDAO;
    private BanqueSangDAO banqueSangDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //if(request.getParameter("ajouter") != null){
            System.out.println("DonnActions ---------------");
           /* int idDonnateur = Integer.parseInt(request.getParameter("idD_aj"));
            int idBS = Integer.parseInt(request.getParameter("idBS_aj"));
            Timestamp dateDonnation = Timestamp.valueOf(request.getParameter("dateD_aj"));

            System.out.println("pre new donn");
            Donnation d = new Donnation(idDonnateur, idBS, dateDonnation);
            System.out.println("pre add");
            Boolean res = donnationDAO.addDonnation(d);
            System.out.println("post add");
            System.out.println("result add : "+res);
            response.sendRedirect("LesBanquesDuSang");
            //response.getWriter().write(res.toString());
*/
            //return;
       // }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
