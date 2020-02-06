package DAO.Implementation;

import DAO.DAOFactory;
import DAO.interfaces.StockSangDAO;
import Model.BanqueSang;
import Model.StockSang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
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
            preparedStatement = connection.prepareStatement("SELECT * from stockSang WHERE idBS = ? and idGS = ?");
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
        finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
        finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
        }finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
        }finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
        }finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
}


    @Override
    public void updateStockSang(StockSang stockSang) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = daoFactory.getConnection();
            preparedStatement=connection.prepareStatement(
                    "update stockSang set quantite = ? where idBS = ? and idGS = ?");
            preparedStatement.setInt(2,stockSang.getIdBS());
            preparedStatement.setInt(3,stockSang.getIdGS());
            preparedStatement.setInt(1,stockSang.getQuantite());

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    @Override
    public void deleteStockSang(StockSang stockSang) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement(
                    "delete from stockSang where idBS = ? and idGS = ?");
            preparedStatement.setInt(1,stockSang.getIdBS());
            preparedStatement.setInt(2,stockSang.getIdGS());
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public int stockPerBanque(int idBS){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        int total = -1;
        try
        {
            connection = daoFactory.getConnection();
            preparedStatement =  connection.prepareStatement(
                    "select sum(quantite) as total from stocksang where idBS = ? ");
            preparedStatement.setInt(1,idBS);
            rs = preparedStatement.executeQuery();
            if(rs.next())
                total = Integer.parseInt(rs.getString("total"));

        }catch (SQLException sql){
            sql.printStackTrace();
        }finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return total;
    }

    public List<Integer> AllstocStatistic()
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Integer> groups = new ArrayList<Integer>(Collections.nCopies(8, 0));

            for (int i=0;i<8;i++) {
                try
                    { connection = daoFactory.getConnection();
                    preparedStatement =  connection.prepareStatement(
                            "select sum(quantite) as total from stocksang where idGS = ? ");
                        preparedStatement.setInt(1,i+1);
                    rs = preparedStatement.executeQuery();
                    if(rs.next())
                        groups.set(i,Integer.parseInt(rs.getString("total")));


            }catch (SQLException sql){
                sql.printStackTrace();
            }finally {
                    if(connection!=null){
                        try {
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        return groups;
    }

    public List<Integer> statsByVille(int idVille){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        BanqueSangDaoImpl banqueSangDao = (BanqueSangDaoImpl) daoFactory.getBanqueSangDaoImpl();
        List<BanqueSang> banqueSangList = banqueSangDao.findBanquesByVille(idVille);
        List<Integer> groups = new ArrayList<Integer>(Collections.nCopies(8, 0));

        for (BanqueSang banque: banqueSangList) {
        for (int i=0;i<8;i++) {
            try
            { connection = daoFactory.getConnection();
                preparedStatement =  connection.prepareStatement(
                        "select sum(quantite) as total from stocksang where idGS = ? and idBS = ?");
                preparedStatement.setInt(1,i+1);
                preparedStatement.setInt(2,banque.getIdBS());
                //System.out.println("idGS : "+(i+1) +" idBS : "+banque.getIdBS());
                rs = preparedStatement.executeQuery();
                if(rs.next())
                     groups.set(i,rs.getInt("total")+groups.get(i));


            }catch (SQLException sql){
                sql.printStackTrace();
            }finally {
                if(connection!=null){
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        }
        return groups;
    }

    @Override
    public List<Integer> statsByBanque(int idBanque) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Integer> groups = new ArrayList<Integer>(Collections.nCopies(8, 0));

        for (int i=0;i<8;i++) {
                try
                { connection = daoFactory.getConnection();
                    preparedStatement =  connection.prepareStatement(
                            "select sum(quantite) as total from stocksang where idGS = ? and idBS = ?");
                    preparedStatement.setInt(1,i+1);
                    preparedStatement.setInt(2,idBanque);
                    rs = preparedStatement.executeQuery();
                    if(rs.next())
                        groups.set(i,rs.getInt("total")+groups.get(i));

                }catch (SQLException sql){
                    sql.printStackTrace();
                }finally {
                    if(connection!=null){
                        try {
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        return groups;
    }


}

/*Id Group Sangin
* A- : 1*/
/* A+ : 1*/
/* B+ : 1*/
/* B- : 1*/
/* AB+ : 1*/
/* AB- : 1*/
/* O+ : 1*/
/* O- : 1*/