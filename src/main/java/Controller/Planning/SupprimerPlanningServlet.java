package Controller.Planning;

import DAO.DAOFactory;
import DAO.interfaces.ConvoiDAO;
import DAO.interfaces.PlanningDAO;
import Model.Planning;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/supprimerPlanning")
public class SupprimerPlanningServlet extends HttpServlet {

    private DAOFactory daoFactory;
    ConvoiDAO convoiDAO;
    PlanningDAO planningDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        daoFactory = DAOFactory.getInstance();
        convoiDAO = daoFactory.getConvoiDaoImpl();
        planningDAO = daoFactory.getPlanningDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            supprimerPlanning(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void supprimerPlanning(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ParseException {
        int idConvoi = Integer.parseInt(request.getParameter("idConvoi"));
        int idville = Integer.parseInt(request.getParameter("idville"));
        String date_debut = request.getParameter("dd");

        Timestamp dateConvoi_debut;

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
        Date date = dateFormat.parse(date_debut);
        long time = date.getTime();
        dateConvoi_debut = new Timestamp(time);



        Planning planning = new Planning(idConvoi,idville,dateConvoi_debut,null);
        planningDAO.deletePlanning(planning);
        response.sendRedirect("Planning");
    }
}
