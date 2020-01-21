package DAO.Implementation;

import DAO.DAOFactory;
import DAO.interfaces.BanqueSangDAO;
import Model.BanqueSang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BanqueSangDaoImpl implements BanqueSangDAO {
    private DAOFactory daoFactory;

    public BanqueSangDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public BanqueSang findBanqueSangById(int idBS){
        Connection conn = null;
        PreparedStatement ps = null;
        BanqueSang banque = null;

        try{
            conn = daoFactory.getConnection();
            ps = conn.prepareStatement("select * from BanqueSang where idBS = ?");
            ps.setInt(1,idBS);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                banque = new BanqueSang(rs.getInt("idBS"),rs.getString("nomBS"),rs.getString("emailBS"),
                        rs.getString("teleBS"),rs.getString("passwordBS"),rs.getString("adresseBS"),rs.getInt("idVille"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return banque;
    }


    @Override
    public BanqueSang findBanqueSangByName(String nom){
        Connection conn = null;
        PreparedStatement ps = null;
        BanqueSang banque = null;

        try{
            conn = daoFactory.getConnection();
            ps = conn.prepareStatement("select * from BanqueSang where nomBS = ?");
            ps.setString(1,nom);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                banque = new BanqueSang(rs.getInt("idBS"),rs.getString("nomBS"),rs.getString("emailBS"),
                        rs.getString("teleBS"),rs.getString("passwordBS"),rs.getString("adresseBS"),rs.getInt("idVille"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return banque;
    }

    @Override
    public BanqueSang findBanqueSangByEmail(String Email){
        Connection conn = null;
        PreparedStatement ps = null;
        BanqueSang banque = null;

        try{
            conn = daoFactory.getConnection();
            ps = conn.prepareStatement("select * from BanqueSang where email = ?");
            ps.setString(1,Email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                banque = new BanqueSang(rs.getInt("idBS"),rs.getString("nomBS"),rs.getString("emailBS"),
                        rs.getString("teleBS"),rs.getString("passwordBS"),rs.getString("adresseBS"),rs.getInt("idVille"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return banque;
    }


    @Override
    public List<BanqueSang> findAllBanqueSang(){
        Connection conn = null;
        PreparedStatement ps = null;
        List<BanqueSang> banqueSangs = new ArrayList<BanqueSang>();

        try{
            conn = daoFactory.getConnection();
            ps = conn.prepareStatement("select * from BanqueSang");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                BanqueSang banque = new BanqueSang(rs.getInt("idBS"),rs.getString("nomBS"),rs.getString("emailBS"),
                        rs.getString("teleBS"),rs.getString("passwordBS"),rs.getString("adresseBS"),rs.getInt("idVille"));
            banqueSangs.add(banque);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return banqueSangs;
    }

    @Override
    public void ajouterBanqueSang(BanqueSang banqueSang){
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = daoFactory.getConnection();
            ps = conn.prepareStatement(
                    "insert into BanqueSang(nomBS,emailBS,teleBS,passwordBS,adresseBS,idVille) " +
                            "values (?,?,?,?,?,?)");
            ps.setString(1,banqueSang.getNomBS());
            ps.setString(2,banqueSang.getEmailBS());
            ps.setString(3,banqueSang.getTeleBS());
            ps.setString(4,banqueSang.getPasswordBS());
            ps.setString(5,banqueSang.getAdresseBS());
            ps.setInt(6,banqueSang.getIdVille());
            ps.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }




    @Override
    public void updateBanqueSang(BanqueSang banqueSang){
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = daoFactory.getConnection();
            ps = conn.prepareStatement(
                    "update BanqueSang set nomBS = ?,emailBS = ?,teleBS = ?,passwordBS = ?,adresseBS = ?,idVille = ? ");

            ps.setString(1,banqueSang.getNomBS());
            ps.setString(2,banqueSang.getEmailBS());
            ps.setString(3,banqueSang.getTeleBS());
            ps.setString(4,banqueSang.getPasswordBS());
            ps.setString(5,banqueSang.getAdresseBS());
            ps.setInt(6,banqueSang.getIdVille());
            ps.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    @Override
    public void deleteBanqueSang(int idBS)
    {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = daoFactory.getConnection();
            ps = conn.prepareStatement("delete from BanqueSang where idBS=?");
            ps.setInt(1,idBS);
            ps.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();

        }
    }

    @Override
    public boolean searchBanqueSangByName(String nom){
        Connection conn = null;
        PreparedStatement ps = null;
        //BanqueSang banqueSang = null;
        try {
            conn = daoFactory.getConnection();
            ps = conn.prepareStatement("select idBS from BanqueSang where nomBS = ?");
            ps.setString(1,"nom");
            ResultSet rs = ps.executeQuery();
            if(rs.next()) return  true;
        }catch (SQLException sqlexc){
            sqlexc.getErrorCode();
        }
        return false;
    }

}
