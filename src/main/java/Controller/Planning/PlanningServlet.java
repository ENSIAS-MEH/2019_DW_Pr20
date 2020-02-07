package Controller.Planning;

import DAO.DAOFactory;
import DAO.interfaces.ConvoiDAO;
import DAO.interfaces.PlanningDAO;
import DAO.interfaces.VilleDAO;
import Model.Convoi;
import Model.Planning;
import Model.Ville;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/Planning")
public class PlanningServlet extends HttpServlet {
    private DAOFactory daoFactory;
    private ConvoiDAO convoiDAO;
    private PlanningDAO planningDao;
    private VilleDAO villeDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        daoFactory = DAOFactory.getInstance();
        convoiDAO = daoFactory.getConvoiDaoImpl();
        villeDAO = daoFactory.getVilleDaoImpl();
        planningDao = daoFactory.getPlanningDaoImpl();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.init();

        HttpSession session = request.getSession();
        if(session.getAttribute("banquesang")==null && session.getAttribute("donnateur")==null){
            response.sendRedirect("SignIn");
        }else {
            try {
                listPlanning(request, response);

            }catch (SQLException ex){
                throw new ServletException(ex);
            }
        }


    }

    private void listPlanning(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException {
        int idConvoi = Integer.parseInt(request.getParameter("idConvoi"));
        Convoi convoi = convoiDAO.findConvoiByID(idConvoi);
        List<Planning> plannings = planningDao.findPalnningByidConvoi(idConvoi);
        List<Ville> villes = villeDAO.getAllVille();


        request.setAttribute("convoi",convoi);
        request.setAttribute("villes",villes);
        request.setAttribute("plannings",plannings);

        this.getServletContext().getRequestDispatcher("/jsp/planning.jsp").forward(request,response);
    }
}
