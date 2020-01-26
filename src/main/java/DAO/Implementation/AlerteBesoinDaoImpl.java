package DAO.Implementation;

import DAO.DAOFactory;
import DAO.interfaces.AlerteBesoinDAO;
import Model.AlerteBesoin;
import Model.GroupeSangin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlerteBesoinDaoImpl implements AlerteBesoinDAO {
    private DAOFactory daoFactory;

    public AlerteBesoinDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public boolean addAlerte(AlerteBesoin ab) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = daoFactory.getConnection();
            ps = connection.prepareStatement("INSERT INTO alertebesoin(idBS,idGS,dateAlerte,descriptionAlerte,enable) VALUES(?,?,?,?,?)");
            ps.setInt(1,ab.getIdBS());
            ps.setInt(2,ab.getGS().getIdGS());
            ps.setTimestamp(3,new Timestamp(System.currentTimeMillis()));
            ps.setString(4,ab.getDescriptionAlerte());
            ps.setBoolean(5,true);
            ps.execute();
            ps.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override
    public List<AlerteBesoin> getAllAlertes() {
        List<AlerteBesoin> alertes = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = daoFactory.getConnection();
            ps = connection.prepareStatement("SELECT * FROM alertebesoin,groupesangin WHERE alertebesoin.idGS=groupesangin.idGS and enable=? ORDER BY dateAlerte DESC");
            ps.setBoolean(1, true);
            rs = ps.executeQuery();
            while (rs.next()){
                GroupeSangin gs =new GroupeSangin(rs.getInt("idGS"),rs.getString("nomGS"));
                AlerteBesoin ab = new AlerteBesoin(rs.getInt("idAlerte"),rs.getInt("idBS"),rs.getTimestamp("dateAlerte"),rs.getString("descriptionAlerte"),rs.getBoolean("enable"));
                ab.setGS(gs);
                alertes.add(ab);
            }
            return alertes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<AlerteBesoin> getAlerteByBS(int idBS) {
        List<AlerteBesoin> alertes = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = daoFactory.getConnection();
            ps = connection.prepareStatement("SELECT * FROM alertebesoin,groupesangin WHERE alertebesoin.idGS=groupesangin.idGS and enable=1 and idBS=? ORDER BY dateAlerte DESC");
            ps.setInt(1,idBS);
            rs = ps.executeQuery();
            while (rs.next()){
                GroupeSangin gs =new GroupeSangin(rs.getInt("idGS"),rs.getString("nomGS"));
                AlerteBesoin ab = new AlerteBesoin(rs.getInt("idAlerte"),rs.getInt("idBS"),rs.getTimestamp("dateAlerte"),rs.getString("descriptionAlerte"),rs.getBoolean("enable"));
                ab.setGS(gs);
                alertes.add(ab);
            }
            return alertes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(connection!=null){
                try {
                    ps.close();
                    rs.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public List<AlerteBesoin> getAlerteByGS(int idGS) {
        List<AlerteBesoin> alertes = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = daoFactory.getConnection();
            ps = connection.prepareStatement("SELECT * FROM alertebesoin,groupesangin WHERE alertebesoin.idGS=groupesangin.idGS and idGS=? ORDER BY dateAlerte DESC");
            ps.setInt(1,idGS);
            rs = ps.executeQuery();
            while (rs.next()){
                GroupeSangin gs =new GroupeSangin(rs.getInt("idGS"),rs.getString("nomGS"));
                AlerteBesoin ab = new AlerteBesoin(rs.getInt("idAlerte"),rs.getInt("idBS"),rs.getTimestamp("dateAlerte"),rs.getString("descriptionAlerte"),rs.getBoolean("enable"));
                ab.setGS(gs);
                alertes.add(ab);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alertes;
    }

    @Override
    public boolean updateAlerte(AlerteBesoin alerteBesoin) {
        /*Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = daoFactory.getConnection();
            ps = connection.prepareStatement("UPDATE alertebesoin SET idGS=?,descriptionAlerte=? WHERE idAlerte=?");
            ps.setInt(1,alerteBesoin.getIdGS());
            ps.setString(2,alerteBesoin.getDescriptionAlerte());
            ps.setInt(3,alerteBesoin.getIdAlerte());
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        return false;
    }

    @Override
    public boolean deleteAlerte(int idAlerte) {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = daoFactory.getConnection();
            ps = connection.prepareStatement("delete FROM alertebesoin where idAlerte = ?");
            ps.setInt(1, idAlerte);
            ps.executeUpdate();
            ps.close();
            connection.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean disableAlerte(int idAlerte) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = daoFactory.getConnection();
            ps = connection.prepareStatement("UPDATE alertebesoin SET enable=? WHERE idAlerte=?");
            ps.setBoolean(1,false);
            ps.setInt(2,idAlerte);
            ps.execute();
            ps.close();
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int getNbrAlerteByBS(int idBS) {
        int nbrAlertes = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = daoFactory.getConnection();
            ps = connection.prepareStatement("SELECT count(idAlert) FROM alertebesoin WHERE idBS=?");
            ps.setInt(1, idBS);
            rs = ps.executeQuery();
            if (rs.next()) {
                nbrAlertes = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nbrAlertes;
    }

    public static void main(String[] args){
        AlerteBesoinDaoImpl alerteBesoinDao =new AlerteBesoinDaoImpl(DAOFactory.getInstance());

        /*AlerteBesoin ab1 = new AlerteBesoin(0,1,7,new Timestamp(System.currentTimeMillis()),"description alerte 1",true);
        AlerteBesoin ab2 = new AlerteBesoin(0,1,8,new Timestamp(System.currentTimeMillis()),"description alerte 2",true);
        AlerteBesoin ab3 = new AlerteBesoin(0,2,8,new Timestamp(System.currentTimeMillis()),"description alerte 3",true);
        AlerteBesoin ab4 = new AlerteBesoin(0,1,5,new Timestamp(System.currentTimeMillis()),"description alerte 4",true);
        AlerteBesoin ab5 = new AlerteBesoin(0,2,4,new Timestamp(System.currentTimeMillis()),"description alerte 5",true);

        alerteBesoinDao.addAlerte(ab1);alerteBesoinDao.addAlerte(ab2);alerteBesoinDao.addAlerte(ab3);alerteBesoinDao.addAlerte(ab4);alerteBesoinDao.addAlerte(ab5);*/

        //System.out.println("Nbr d alertes du BS 2 : "+ alerteBesoinDao.getNbrAlerteByBS(2));

        //alerteBesoinDao.deleteAlerte(2);
        /*alerteBesoinDao.disableAlerte(3);
        AlerteBesoin ab10 = new AlerteBesoin();
        ab10.setIdAlerte(4); ab10.setIdGS(8);ab10.setDescriptionAlerte("dessssssssssssssssssc 4");
        alerteBesoinDao.updateAlerte(ab10);*/
        /*for(AlerteBesoin ab: alerteBesoinDao.getAllAlertes()){
            System.out.println(ab);
        }*/
    }
}
