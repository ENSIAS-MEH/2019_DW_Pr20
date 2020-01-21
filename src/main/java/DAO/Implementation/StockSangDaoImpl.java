package DAO.Implementation;

import DAO.DAOFactory;
import DAO.interfaces.StockSangDAO;
import Model.StockSang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StockSangDaoImpl implements StockSangDAO {
    private DAOFactory daoFactory;

    public StockSangDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public StockSang findStockById(int idBS, int idGS){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        StockSang stock = null;
        try{
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("select * from stockSang WHERE idBS = ? and idGS = ?");
            preparedStatement.setInt(1,idBS);
            preparedStatement.setInt(2,idGS);

            ResultSet rs=preparedStatement.executeQuery();
            //System.out.println("Testtttt1");
            if(rs.next()){
                //System.out.println("Testtttt2");
                stock = new StockSang(rs.getInt("idBS"),rs.getInt("idGS"),rs.getInt("quantite"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return stock;
    }

    @Override
    public List<StockSang> findStockByBanqueSang(int idBS){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<StockSang> stockSangs = new ArrayList<StockSang>();

        try{
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("select * from stockSang WHERE idBS = ?");
            preparedStatement.setInt(1,idBS);

            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                StockSang
                stock = new StockSang(rs.getInt("idBS"),rs.getInt("idGS"),rs.getInt("quantite"));
                stockSangs.add(stock);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return stockSangs;
    }


    @Override
    public List<StockSang> findStockByGroupSang(int idGS){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<StockSang> stockSangs = new ArrayList<StockSang>();

        try{
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("select * from stockSang WHERE idGS = ?");
            preparedStatement.setInt(1,idGS);

            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                StockSang
                        stock = new StockSang(rs.getInt("idBS"),rs.getInt("idGS"),rs.getInt("quantite"));
                stockSangs.add(stock);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return stockSangs;
    }


    @Override
    public List<StockSang> findAll(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<StockSang> stockSangs = new ArrayList<StockSang>();

        try{
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("select * from stockSang");
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                StockSang
                        stock = new StockSang(rs.getInt("idBS"),rs.getInt("idGS"),rs.getInt("quantite"));
                stockSangs.add(stock);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return stockSangs;
    }

    @Override
    public void ajouterStockSang(StockSang stockSang) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection=daoFactory.getConnection();
            preparedStatement=connection.prepareStatement(
                    "insert into stockSang(idBS,idGS,quantite) VALUES(?,?,?) ");
            preparedStatement.setInt(1,stockSang.getIdBS());
            preparedStatement.setInt(2,stockSang.getIdGS());
            preparedStatement.setInt(3,stockSang.getQuantite());

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
}


    @Override
    public void updateStockSang(StockSang stockSang) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection=daoFactory.getConnection();
            preparedStatement=connection.prepareStatement(
                    "update stockSang set idBS = ?,idGS = ?,quantite = ?");
            preparedStatement.setInt(1,stockSang.getIdBS());
            preparedStatement.setInt(2,stockSang.getIdGS());
            preparedStatement.setInt(3,stockSang.getQuantite());

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }



    @Override
    public void deleteStockSang(StockSang stockSang) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection=daoFactory.getConnection();
            preparedStatement=connection.prepareStatement(
                    "delete from stockSang where idBS = ? and idGS = ?");
            preparedStatement.setInt(1,stockSang.getIdBS());
            preparedStatement.setInt(2,stockSang.getIdGS());
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
