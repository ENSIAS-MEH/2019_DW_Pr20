package Controller.Planning;

import DAO.DAOFactory;
import DAO.interfaces.ConvoiDAO;
import DAO.interfaces.PlanningDAO;
import Model.Convoi;
import Model.Planning;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


@WebServlet("/AjouterPlanning")
public class AjouterPlanningServlet extends HttpServlet {

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

         /*
        HttpSession session = request.getSession();
        if(session.getAttribute("BanqueSang")==null){
            response.sendRedirect("/jsp/login.jsp");
        }else {

        }
        */
        try {
            insertPlanning(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new ServletException(e);
        }
    }

    private void insertPlanning(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException {
        int idConvoi = Integer.parseInt(request.getParameter("idConvoi"));
        int idville = Integer.parseInt(request.getParameter("idville"));
        String date_debut = request.getParameter("dd");
        String date_fin = request.getParameter("df");

        Timestamp dateConvoi_debut;
        Timestamp dateConvoi_fin;

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = (Date) dateFormat.parse(date_debut);
        long time = date.getTime();
        dateConvoi_debut = new Timestamp(time);

        date = (Date) dateFormat.parse(date_fin);
        time = date.getTime();
        dateConvoi_fin = new Timestamp(time);

        Planning planning = new Planning(idConvoi,idville,dateConvoi_debut,dateConvoi_fin);

        planningDAO.addPlanning(planning);
        response.sendRedirect("Convois");

    }
}
