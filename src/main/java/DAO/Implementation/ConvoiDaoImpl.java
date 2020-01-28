package DAO.Implementation;

import DAO.DAOFactory;
import DAO.interfaces.ConvoiDAO;
import Model.Convoi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConvoiDaoImpl implements ConvoiDAO {
    private DAOFactory daoFactory;

    public ConvoiDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Convoi findConvoiByID(int idConvoi) {
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        Convoi convoi = new Convoi();
        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT titreConvoi,desciption,idBS FROM convoi where idConvoi = "+idConvoi+";");


            if (resultat.next()) {

                String titreConvoi = resultat.getString("titreConvoi");
                String desciption = resultat.getString("desciption");
                int idBS = resultat.getInt("idBS");

                convoi.setIdConvoi(idConvoi);
                convoi.setTitreConvoi(titreConvoi);
                convoi.setDescription(desciption);
                convoi.setIdBS(idBS);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return convoi;
    }

    @Override
    public List<Convoi> allConvoi() {
        List<Convoi> convois = new ArrayList<Convoi>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM convoi;");

            while (resultat.next()) {
                int idConvoi = resultat.getInt("idConvoi");
                String titreConvoi = resultat.getString("titreConvoi");
                String description = resultat.getString("desciption");
                int idBS = resultat.getInt("idBS");


                Convoi convoi = new Convoi();
                convoi.setIdConvoi(idConvoi);
                convoi.setTitreConvoi(titreConvoi);
                convoi.setDescription(description);
                convoi.setIdBS(idBS);

                convois.add(convoi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return convois;
    }

    @Override
    public List<Convoi> allConvoiByBanque(int idBS) {
        List<Convoi> convois = new ArrayList<Convoi>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT idConvoi,titreConvoi,desciption FROM convoi where idBS = "+idBS+";");

            while (resultat.next()) {
                int idConvoi = resultat.getInt("idConvoi");
                String titreConvoi = resultat.getString("titreConvoi");
                String desciption = resultat.getString("desciption");



                Convoi convoi = new Convoi();
                convoi.setIdConvoi(idConvoi);
                convoi.setTitreConvoi(titreConvoi);
                convoi.setDescription(desciption);
                convoi.setIdBS(idBS);

                convois.add(convoi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return convois;
    }

    @Override
    public void addConvoi(Convoi convoi) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO convoi(titreConvoi, desciption, idBS) VALUES(?, ?, ?);");
            preparedStatement.setString(1, convoi.getTitreConvoi());
            preparedStatement.setString(2, convoi.getDescription());
            preparedStatement.setInt(3, convoi.getIdBS());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateConvoi(Convoi convoi) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("UPDATE convoi set titreConvoi=?, description=?, idBS=? where idConvoi=?;");
            preparedStatement.setString(1, convoi.getTitreConvoi());
            preparedStatement.setString(2, convoi.getDescription());
            preparedStatement.setInt(3, convoi.getIdBS());
            preparedStatement.setInt(4,convoi.getIdConvoi());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteConvoi(Convoi convoi) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("DELETE FROM convoi  where idConvoi=?;");

            preparedStatement.setInt(1,convoi.getIdConvoi());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
