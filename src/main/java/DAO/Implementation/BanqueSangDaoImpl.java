package DAO.Implementation;

import DAO.DAOFactory;
import DAO.interfaces.BanqueSangDAO;
import Model.Admin;
import DAO.interfaces.GroupeSanginDAO;
import DAO.interfaces.StockSangDAO;
import Model.BanqueSang;
import Model.GroupeSangin;
import Model.StockSang;

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
            ps = conn.prepareStatement("SELECT * from BanqueSang where idBS = ?");
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
    public BanqueSang findBanqueSang(String mail, String password){
        Connection conn = null;
        PreparedStatement ps = null;
        BanqueSang banque = null;

        try{
            conn = daoFactory.getConnection();
            ps = conn.prepareStatement("select * from BanqueSang where emailBS = ? and passwordBS=?");
            ps.setString(1,mail);
            ps.setString(2,password);
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
        GroupeSanginDAO groupeSanginDAO = daoFactory.getGroupeSanginDaoImpl();
        StockSangDAO stockSangDAO = daoFactory.getStockSangDaoImpl();
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
            /*Aprés la création du banqueDuSang, il faut initialiser son stock*/
            List<GroupeSangin> groupeSanginList = groupeSanginDAO.findAll();

            for (GroupeSangin group : groupeSanginList) {
                StockSang stockSang = new StockSang();
                stockSang.setIdGS(group.getIdGS());
                ps = conn.prepareStatement("select idBS from banqueSang where emailBS = ?");
                ps.setString(1,banqueSang.getEmailBS());
                ResultSet rs = ps.executeQuery();
                if(rs.next())
                stockSang.setIdBS(rs.getInt("idBS"));
                stockSang.setQuantite(0);
                stockSangDAO.ajouterStockSang(stockSang);
            }

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
                    "update BanqueSang set nomBS = ?,emailBS = ?,teleBS = ?,passwordBS = ?,adresseBS = ?,idVille = ?  where idBS = ?");

            ps.setString(1,banqueSang.getNomBS());
            ps.setString(2,banqueSang.getEmailBS());
            ps.setString(3,banqueSang.getTeleBS());
            ps.setString(4,banqueSang.getPasswordBS());
            ps.setString(5,banqueSang.getAdresseBS());
            ps.setInt(6,banqueSang.getIdVille());
            ps.setInt(7,banqueSang.getIdVille());
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

    @Override
    public int countBanqueSang(){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = daoFactory.getConnection();
            ps = conn.prepareStatement("select count(*) as nbr from BanqueSang");
            ResultSet rs = ps.executeQuery();
            if(rs.next()) return  rs.getInt("nbr");
        }catch (SQLException sqlexc){
            sqlexc.getErrorCode();
        }
        return 0;
    }

    @Override
    public Admin getAdmin(String mail, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        Admin admin = null;

        try{
            conn = daoFactory.getConnection();
            ps = conn.prepareStatement("select * from admin where emailAdmin = ? and passwordAdmin = ?");
            ps.setString(1,mail);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                admin = new Admin(rs.getInt(1),rs.getString(2),rs.getString(3));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return admin;
    }

    @Override
    public List<BanqueSang> findBanquesByVille(int idVille) {
        Connection conn = null;
        PreparedStatement ps = null;
        List<BanqueSang> banqueSangs = new ArrayList<BanqueSang>();

        try{
            conn = daoFactory.getConnection();
            ps = conn.prepareStatement("select * from BanqueSang where idVille = ?");
            ps.setInt(1,idVille);
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

}
