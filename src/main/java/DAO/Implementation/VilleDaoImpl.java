package DAO.Implementation;

import DAO.DAOFactory;
import DAO.interfaces.VilleDAO;
import Model.Ville;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VilleDaoImpl implements VilleDAO {
    private DAOFactory daoFactory;

    public VilleDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void addVille(Ville ville) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = daoFactory.getConnection();
            ps = connection.prepareStatement("INSERT INTO ville (nomVille) VALUES (?)");
            ps.setString(1, ville.getNomVille());
            ps.executeUpdate();

            ps.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Ville> getAllVille() {
        List<Ville> villes = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = daoFactory.getConnection();
            ps = connection.prepareStatement("select  * from  ville ORDER BY nomVille");
            rs = ps.executeQuery();
            while (rs.next()){
                Ville ville = new Ville();
                ville.setIdVille(rs.getInt(1));
                ville.setNomVille(rs.getString(2));
                villes.add(ville);
            }
            ps.close();
            return villes;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Ville getVilleById(int idVille) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Ville ville;

        try{
            connection = daoFactory.getConnection();
            ps = connection.prepareStatement("SELECT * from ville where idVille = ?");
            ps.setInt(1, idVille);
            rs = ps.executeQuery();
            if(rs.next()){
                ville = new Ville();
                ville.setIdVille(rs.getInt(1));
                ville.setNomVille(rs.getString(2));
                ps.close();
                return ville;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Ville getVilleByName(String nomVille) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Ville ville;

        try{
            connection = daoFactory.getConnection();
            ps = connection.prepareStatement("SELECT * from ville where nomVille = ?");
            ps.setString(1, nomVille);
            rs = ps.executeQuery();
            if(rs.next()){
                ville = new Ville();
                ville.setIdVille(rs.getInt(1));
                ville.setNomVille(rs.getString(2));
                ps.close();
                return ville;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Ville> searchVilleByName(String nomVille) {
        List<Ville> villes = new ArrayList<Ville>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = daoFactory.getConnection();
            ps = connection.prepareStatement("SELECT * FROM ville WHERE nomVille LIKE ?");
            ps.setString(1, "%"+nomVille+"%");
            rs = ps.executeQuery();
            while (rs.next()){
                Ville ville = new Ville();
                ville.setIdVille(rs.getInt(1));
                ville.setNomVille(rs.getString(2));
                villes.add(ville);
            }
            ps.close();
            return villes;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void deleteVille(int idVille) {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = daoFactory.getConnection();
            ps = connection.prepareStatement("delete FROM ville where idVille = ?");
            ps.setInt(1, idVille);
            ps.executeUpdate();
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /*public static void main(String[] args){
        VilleDaoImpl villeDao = new VilleDaoImpl(DAOFactory.getInstance());
       Ville ville1 = new Ville();ville1.setNomVille("Casablanca");
        Ville ville2 = new Ville();ville2.setNomVille("Rabat");
        Ville ville3 = new Ville();ville3.setNomVille("Tanger");
        Ville ville4 = new Ville();ville4.setNomVille("Fes");
        Ville ville5 = new Ville();ville5.setNomVille("Meknes");
        villeDao.addVille(ville1);villeDao.addVille(ville2);villeDao.addVille(ville3);villeDao.addVille(ville4);villeDao.addVille(ville5);
       // villeDao.deleteVille(5);
       List<Ville> villes = villeDao.getAllVille();
        for (Ville v:villes){
            System.out.println(v);
        }
        //System.out.println(villeDao.getVilleById(1));
    }*/

}
