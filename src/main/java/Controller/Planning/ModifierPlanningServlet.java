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

@WebServlet("/ModifierPlanning")
public class ModifierPlanningServlet extends HttpServlet {

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
        try {
            modifierPlanning(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new ServletException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    private void modifierPlanning(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ParseException {
        int idConvoi = Integer.parseInt(request.getParameter("idConvoi"));
        int idville = Integer.parseInt(request.getParameter("idville"));
        String date_debut = request.getParameter("dd");
        String date_fin = request.getParameter("df");

        Timestamp dateConvoi_debut;
        Timestamp dateConvoi_fin;

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
        Date date = dateFormat.parse(date_debut);
        long time = date.getTime();
        dateConvoi_debut = new Timestamp(time);

        DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        Date date2 = dateFormat2.parse(date_fin);
        long time2 = date2.getTime();
        dateConvoi_fin = new Timestamp(time2);

        Planning planning = new Planning(idConvoi,idville,dateConvoi_debut,dateConvoi_fin);
        planningDAO.updatePlanning(planning);
        response.sendRedirect("Planning?idConvoi="+idConvoi);

    }
}
