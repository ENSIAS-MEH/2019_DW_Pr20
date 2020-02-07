package DAO.Implementation;

import DAO.DAOFactory;
import DAO.interfaces.DonnateurDAO;
import Model.Donnateur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DonnateurDaoImpl implements DonnateurDAO {

    private DAOFactory daoFactory;

    public DonnateurDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public boolean addDonnateur(Donnateur donnateur){
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn  = daoFactory.getConnection();
            String sql = "INSERT INTO donnateur(cin, nomD, prenomD, teleD, emailD, passwordD, idVille, idGS) VALUES(?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);

            ps.setString(1, donnateur.getCin());
            ps.setString(2, donnateur.getNomD());
            ps.setString(3, donnateur.getPrenomD());
            ps.setString(4, donnateur.getTeleD());
            ps.setString(5, donnateur.getEmailD());
            ps.setString(6, donnateur.getPasswordD());
            ps.setInt(7, donnateur.getIdVille());
            ps.setInt(8, donnateur.getIdGS());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override
    public boolean updateDonnateur(Donnateur donnateur){
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = daoFactory.getConnection();
            ps = conn.prepareStatement("UPDATE donnateur SET cin=?, nomD=?, prenomD=?, teleD=?, emailD=?, passwordD=?, idVille=?, " +
                    "idGS=? WHERE idDonnateur=?");

            ps.setString(1, donnateur.getCin());
            ps.setString(2, donnateur.getNomD());
            ps.setString(3, donnateur.getPrenomD());
            ps.setString(4, donnateur.getTeleD());
            ps.setString(5, donnateur.getEmailD());
            ps.setString(6, donnateur.getPasswordD());
            ps.setInt(7, donnateur.getIdVille());
            ps.setInt(8, donnateur.getIdGS());
            ps.setInt(9, donnateur.getIdDonnateur());

            ps.executeUpdate();
            return true;

        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean deleteDonnateur(String email){
        PreparedStatement ps = null;
        Connection conn = null;
        String sql = "DELETE FROM donnateur WHERE emailD=? ;" ;

        try {
            conn = daoFactory.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, email);

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public Donnateur getDonnateur(String email, String password){
        Connection conn = null;
        Statement st = null;

        try {
            conn = daoFactory.getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM donnateur WHERE emailD='" + email + "' AND passwordD='" + password + "';");
            if (rs.next()) {
                Donnateur donnateur = new Donnateur();
                donnateur.setIdDonnateur(rs.getInt(1));
                donnateur.setCin(rs.getString(2));
                donnateur.setNomD(email);
                donnateur.setPrenomD(rs.getString(4));
                donnateur.setTeleD(rs.getString(5));
                donnateur.setEmailD(rs.getString(6));
                donnateur.setPasswordD(password);
                donnateur.setIdVille(rs.getInt(8));
                donnateur.setIdGS(rs.getInt(9));
                return donnateur;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public Donnateur getDonnateurById(int id){
        Connection conn = null;
        Statement st = null;

        try {
            conn = daoFactory.getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM donnateur WHERE idDonnateur='"+ id +"';");
            if (rs.next()) {
                Donnateur donnateur = new Donnateur();
                donnateur.setIdDonnateur(id);
                donnateur.setCin(rs.getString(2));
                donnateur.setNomD(rs.getString(3));
                donnateur.setPrenomD(rs.getString(4));
                donnateur.setTeleD(rs.getString(5));
                donnateur.setEmailD(rs.getString(6));
                donnateur.setPasswordD(rs.getString(7));
                donnateur.setIdVille(rs.getInt(8));
                donnateur.setIdGS(rs.getInt(9));
                return donnateur;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public boolean findDonnateurByMail(String email){
        Connection conn = null;
        Statement st = null;

        try {
            conn = daoFactory.getConnection();
            st = conn.createStatement();
            ResultSet result = st.executeQuery("SELECT * FROM donnateur WHERE emailD='"+ email +"';");

            if(result.next()){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override
    public List<Donnateur> getAllDonnateurs(){
        Connection conn = null;
        Statement st = null;

        try {
            conn = daoFactory.getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM donnateur;");
            List<Donnateur> donorsList = new ArrayList<>();

            while(rs.next()){
                Donnateur donnateur = new Donnateur();
                donnateur.setIdDonnateur(rs.getInt(1));
                donnateur.setCin(rs.getString(2));
                donnateur.setNomD(rs.getString(3));
                donnateur.setPrenomD(rs.getString(4));
                donnateur.setTeleD(rs.getString(5));
                donnateur.setEmailD(rs.getString(6));
                donnateur.setPasswordD(rs.getString(7));
                donnateur.setIdVille(rs.getInt(8));
                donnateur.setIdGS(rs.getInt(9));

                donorsList.add(donnateur);
            }
            return donorsList;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }



    @Override
    public List<Donnateur> getAllDonnateursVilleGS(int idVille, int idGS){
        Connection conn = null;
        Statement st = null;

        try {
            conn = daoFactory.getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM donnateur WHERE idVille="+idVille+" AND idGS="+ idGS+";");
            List<Donnateur> donorsList = new ArrayList<>();

            while(rs.next()){
                Donnateur donnateur = new Donnateur();
                donnateur.setIdDonnateur(rs.getInt(1));
                donnateur.setCin(rs.getString(2));
                donnateur.setNomD(rs.getString(3));
                donnateur.setPrenomD(rs.getString(4));
                donnateur.setTeleD(rs.getString(5));
                donnateur.setEmailD(rs.getString(6));
                donnateur.setPasswordD(rs.getString(7));
                donnateur.setIdVille(rs.getInt(8));
                donnateur.setIdGS(rs.getInt(9));

                donorsList.add(donnateur);
            }
            return donorsList;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Donnateur> getDonnateursByCity(int idVille){
        Connection conn = null;
        Statement st = null;

        try {
            conn = daoFactory.getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM donnateur WHERE idVille="+idVille+";");
            List<Donnateur> donorsList = new ArrayList<>();

            while(rs.next()){
                Donnateur donnateur = new Donnateur();
                donnateur.setIdDonnateur(rs.getInt(1));
                donnateur.setCin(rs.getString(2));
                donnateur.setNomD(rs.getString(3));
                donnateur.setPrenomD(rs.getString(4));
                donnateur.setTeleD(rs.getString(5));
                donnateur.setEmailD(rs.getString(6));
                donnateur.setPasswordD(rs.getString(7));
                donnateur.setIdVille(rs.getInt(8));
                donnateur.setIdGS(rs.getInt(9));

                donorsList.add(donnateur);
            }
            return donorsList;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public int donnationLastM(int idD){
        Connection conn = null;
        PreparedStatement ps = null;
        int nbrDonors = 0;

        try {
            conn = daoFactory.getConnection();
            ps = conn.prepareStatement("select count(*) as nbr from donnation where idDonnateur="+idD+" and " +
                    "dateDonnation >= now()-interval 3 month ;" );
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                nbrDonors = Integer.parseInt(rs.getString("nbr"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return nbrDonors;
    }

    @Override
    public List<Donnateur> getDonnateursByGrpSg(int idGS){
        Connection conn = null;
        Statement st = null;

        try {
            conn = daoFactory.getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM donnateur WHERE idGS="+idGS+";");
            List<Donnateur> donorsList = new ArrayList<>();

            while(rs.next()){
                Donnateur donnateur = new Donnateur();
                donnateur.setIdDonnateur(rs.getInt(1));
                donnateur.setCin(rs.getString(2));
                donnateur.setNomD(rs.getString(3));
                donnateur.setPrenomD(rs.getString(4));
                donnateur.setTeleD(rs.getString(5));
                donnateur.setEmailD(rs.getString(6));
                donnateur.setPasswordD(rs.getString(7));
                donnateur.setIdVille(rs.getInt(8));
                donnateur.setIdGS(rs.getInt(9));

                donorsList.add(donnateur);
            }
            return donorsList;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public int donorsNbrPerCity(int idVille){
        Connection conn = null;
        PreparedStatement ps = null;
        int nbrDonors = 0;

        try {
            conn = daoFactory.getConnection();
            ps = conn.prepareStatement("SELECT count(idDonnateur) AS nbr FROM donnateur WHERE idVille="+idVille +";");
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                nbrDonors = Integer.parseInt(rs.getString("nbr"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return nbrDonors;
    }

    @Override
    public int donorsNbrPerGrpSg(int idGS){
        Connection conn = null;
        PreparedStatement ps = null;
        int nbrDonors = 0;

        try {
            conn = daoFactory.getConnection();
            ps = conn.prepareStatement("SELECT count(idDonnateur) AS nbr FROM donnateur WHERE idGS="+idGS+";" );
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                nbrDonors = Integer.parseInt(rs.getString("nbr"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return nbrDonors;
    }

}
