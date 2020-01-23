package DAO.Implementation;

import DAO.DAOFactory;
import DAO.interfaces.DonnationDAO;
import Model.Donnation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DonnationDaoImpl implements DonnationDAO {
    private DAOFactory daoFactory;

    public DonnationDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public boolean addDonnation(Donnation donnation) {
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "INSERT INTO Donnation(idDonnateur, idBS, dateDonnation) VALUES(?,?,?);";

        try {
            conn = daoFactory.getConnection();
            ps = conn.prepareStatement(query);

            ps.setInt(1, donnation.getIdDonnateur());
            ps.setInt(2, donnation.getIdBS());
            ps.setTimestamp(3, donnation.getDateDonnation());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateDonnation(int idDonnateur, Timestamp dateDonnation, Donnation donnation){
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = daoFactory.getConnection();
            ps = conn.prepareStatement("UPDATE donnation SET idDonnateur=?, idBS=?, dateDonnation=? WHERE idDonnateur=? " +
                    "AND dateDonnation=?;");

            ps.setInt(1, donnation.getIdDonnateur());
            ps.setInt(2, donnation.getIdBS());
            ps.setTimestamp(3, donnation.getDateDonnation());
            ps.setInt(4, idDonnateur);
            ps.setTimestamp(5, dateDonnation);

            ps.executeUpdate();
            return true;

        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteDonnation(int idDonnateur, Timestamp dateDonnation){
        PreparedStatement ps = null;
        Connection conn = null;
        String sql = "DELETE FROM donnation WHERE idDonnateur=? AND dateDonnation=?;" ;

        try {
            conn = daoFactory.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, idDonnateur);
            ps.setTimestamp(2, dateDonnation);

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Donnation> getAllDennation(){
        Connection conn = null;
        Statement st = null;

        try {
            conn = daoFactory.getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM donnation;");
            List<Donnation> donationsList = new ArrayList<>();

            while(rs.next()){
                Donnation donnation = new Donnation();
                donnation.setIdDonnateur(rs.getInt(1));
                donnation.setIdBS(rs.getInt(2));
                donnation.setDateDonnation(rs.getTimestamp(3));

                donationsList.add(donnation);
            }
            return donationsList;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Donnation> getAllDonnationsVille(int idVille){
        Connection conn = null;
        Statement st = null;

        try {
            conn = daoFactory.getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT dn.idDonnateur, idBS, dateDonnation, idVille FROM donnation dn, donnateur dr " +
                    "WHERE dn.idDonnateur=dr.idDonnateur AND idVille="+idVille+";");
            List<Donnation> donationsList = new ArrayList<>();

            while(rs.next()){
                Donnation donnation = new Donnation();
                donnation.setIdDonnateur(rs.getInt(1));
                donnation.setIdBS(rs.getInt(2));
                donnation.setDateDonnation(rs.getTimestamp(3));

                donationsList.add(donnation);
            }
            return donationsList;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Donnation> getAllDonnationsDonnateur(int idDonnateur){
        Connection conn = null;
        Statement st = null;

        try {
            conn = daoFactory.getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM donnation WHERE idDonnateur="+idDonnateur+";");
            List<Donnation> donationsList = new ArrayList<>();

            while(rs.next()){
                Donnation donnation = new Donnation();
                donnation.setIdDonnateur(idDonnateur);
                donnation.setIdBS(rs.getInt(2));
                donnation.setDateDonnation(rs.getTimestamp(3));

                donationsList.add(donnation);
            }
            return donationsList;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
