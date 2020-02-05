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
    public boolean addDonnation(int idDonnateur, int idBS) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = daoFactory.getConnection();
            ps = conn.prepareStatement("INSERT INTO Donnation(idDonnateur, idBS) VALUES(?,?);");

            ps.setInt(1, idDonnateur);
            ps.setInt(2, idBS);

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
            ResultSet rs = st.executeQuery("SELECT * FROM donnation ORDER BY dateDonnation DESC;");
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
            ResultSet rs = st.executeQuery("SELECT idDonnateur, d.idBS, dateDonnation, idVille FROM donnation d, banquesang b " +
                    "WHERE d.idBS=b.idBS AND idVille="+idVille+";");
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
    public List<Donnation> getAllDonnationsBanq(int idBS){
        Connection conn = null;
        Statement st = null;

        try {
            conn = daoFactory.getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM donnation WHERE idBS="+idBS+";");
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
    public List<Donnation> getAllDonnationsGS(String nomGS){
        Connection conn = null;
        Statement st = null;

        try {
            conn = daoFactory.getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT dn.idDonnateur, idBS, dateDonnation FROM donnation dn, donnateur dt, groupesangin g " +
                    "WHERE dn.idDonnateur = dt.idDonnateur AND dt.idGS = g.idGS AND nomGS ='"+nomGS+"';");
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
    public List<Donnation> getAllDonnationsVilleGS(int idVille, int idGS){
        Connection conn = null;
        Statement st = null;

        try {
            conn = daoFactory.getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT dn.idDonnateur, b.idBS, dateDonnation FROM donnation dn, donnateur dr " +
                    ", banquesang b WHERE dn.idBS=b.idBS AND dn.idDonnateur=dr.idDonnateur AND idGS="+ idGS +" AND b.idVille="+idVille+";");
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

    @Override
    public int DonnationsNbrPerVille(int idVille){
        Connection conn = null;
        PreparedStatement ps = null;
        int nbr = 0;

        try {
            conn = daoFactory.getConnection();
            ps = conn.prepareStatement("SELECT count(idDonnateur) AS nbr FROM donnation d, banquesang b " +
                    "WHERE d.idBS = b.idBS AND idVille ="+idVille +";");
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                nbr = Integer.parseInt(rs.getString("nbr"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return nbr;
    }

    @Override
    public int DonnationsNbrPerBanq(int idBS){
        Connection conn = null;
        PreparedStatement ps = null;
        int nbr = 0;

        try {
            conn = daoFactory.getConnection();
            ps = conn.prepareStatement("SELECT count(idDonnateur) AS nbr FROM donnation d WHERE idBS ="+idBS +";");
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                nbr = Integer.parseInt(rs.getString("nbr"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return nbr;
    }

    @Override
    public int DonnationsNbrPerDonnateur(int idDonnateur){
        Connection conn = null;
        PreparedStatement ps = null;
        int nbr = 0;

        try {
            conn = daoFactory.getConnection();
            ps = conn.prepareStatement("SELECT count(idDonnateur) AS nbr FROM donnation d WHERE idDonnateur ="+idDonnateur +";");
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                nbr = Integer.parseInt(rs.getString("nbr"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return nbr;
    }

    @Override
    public int DonnationsNbrPerVilleGS(int idVille, int idGS){
        Connection conn = null;
        PreparedStatement ps = null;
        int nbr = 0;

        try {
            conn = daoFactory.getConnection();
            ps = conn.prepareStatement("SELECT count(dn.idDonnateur) AS nbr FROM donnation dn, donnateur dr , banquesang b " +
                    "WHERE dn.idBS=b.idBS AND dn.idDonnateur=dr.idDonnateur AND idGS="+ idGS +" AND b.idVille="+idVille+";");
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                nbr = Integer.parseInt(rs.getString("nbr"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return nbr;
    }

}