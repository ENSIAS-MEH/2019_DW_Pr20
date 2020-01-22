package DAO.Implementation;

import DAO.DAOFactory;
import DAO.interfaces.PlanningDAO;
import Model.Convoi;
import Model.Planning;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlanningDaoImpl implements PlanningDAO {
    private DAOFactory daoFactory;

    public PlanningDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Planning findPlanningByIdConvoiAndIdVilleAnddate(int idConvoi, int idVille, Timestamp dateConvoi_debut) {
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        Planning planning = new Planning();
        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT dateConvoi_fin FROM planning WHERE idConvoi = " + idConvoi + " and idVille = "+idVille+" and dateConvoi_debut = "+dateConvoi_debut+";");

            if (resultat.next()) {
                Timestamp dateConvoi_fin = resultat.getTimestamp("dateConvoi_fin");

                planning.setIdConvoi(idConvoi);
                planning.setIdVille(idVille);
                planning.setDateConvoi_debut(dateConvoi_debut);
                planning.setDateConvoi_fin(dateConvoi_fin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return planning;
    }

    @Override
    public List<Planning> findPalnningByidConvoi(int idConvoi) {
        List<Planning> plannings = new ArrayList<Planning>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM planning WHERE idConvoi = "+idConvoi+";");

            while (resultat.next()) {

                int idVille = resultat.getInt("idVille");
                Timestamp dateConvoi_debut = resultat.getTimestamp("dateConvoi_debut");
                Timestamp dateConvoi_fin = resultat.getTimestamp("dateConvoi_fin");


               Planning planning = new Planning();
               planning.setIdConvoi(idConvoi);
               planning.setIdVille(idVille);
               planning.setDateConvoi_debut(dateConvoi_debut);
               planning.setDateConvoi_fin(dateConvoi_fin);

                plannings.add(planning);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return plannings;


    }

    @Override
    public List<Planning> findPalnningByidVille(int idVille) {
        List<Planning> plannings = new ArrayList<Planning>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM planning WHERE idVille = "+idVille+";");

            while (resultat.next()) {

                int idConvoi = resultat.getInt("idConvoi");
                Timestamp dateConvoi_debut = resultat.getTimestamp("dateConvoi_debut");
                Timestamp dateConvoi_fin = resultat.getTimestamp("dateConvoi_fin");


                Planning planning = new Planning();
                planning.setIdConvoi(idConvoi);
                planning.setIdVille(idVille);
                planning.setDateConvoi_debut(dateConvoi_debut);
                planning.setDateConvoi_fin(dateConvoi_fin);

                plannings.add(planning);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return plannings;
    }

    @Override
    public List<Planning> findPalnningBydate(Timestamp dateConvoi_debut, Timestamp dateConvoi_fin) {
        List<Planning> plannings = new ArrayList<Planning>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM planning WHERE (dateConvoi_debut BETWEEN "+dateConvoi_debut+" AND "+dateConvoi_fin+") AND (dateConvoi_debut BETWEEN "+dateConvoi_debut+" AND "+dateConvoi_fin+");");

            while (resultat.next()) {

                int idConvoi = resultat.getInt("idConvoi");
                int idVille = resultat.getInt("idVille");



                Planning planning = new Planning();
                planning.setIdConvoi(idConvoi);
                planning.setIdVille(idVille);
                planning.setDateConvoi_debut(dateConvoi_debut);
                planning.setDateConvoi_fin(dateConvoi_fin);

                plannings.add(planning);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return plannings;
    }

    @Override
    public void addPlanning(Planning planning) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO Planning(idConvoi, idVille, dateConvoi_debut, dateConvoi_fin) VALUES(?, ?, ?, ?);");
            preparedStatement.setInt(1, planning.getIdConvoi());
            preparedStatement.setInt(2, planning.getIdVille());
            preparedStatement.setTimestamp(3, planning.getDateConvoi_debut());
            preparedStatement.setTimestamp(4, planning.getDateConvoi_fin());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePlanning(Planning planning) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("UPDATE planning set dateConvoi_fin=? where idConvoi=? and idVille=? and dateConvoi_debut=?;");
            preparedStatement.setTimestamp(1, planning.getDateConvoi_fin());

            preparedStatement.setInt(2, planning.getIdConvoi());
            preparedStatement.setInt(3,planning.getIdVille());
            preparedStatement.setTimestamp(4, planning.getDateConvoi_debut());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePlanning(Planning planning) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("DELETE FROM planning WHERE IdConvoi=? and IdVille=? and dateConvoi_debut=? ");

            preparedStatement.setInt(1, planning.getIdConvoi());
            preparedStatement.setInt(2,planning.getIdVille());
            preparedStatement.setTimestamp(3, planning.getDateConvoi_debut());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
