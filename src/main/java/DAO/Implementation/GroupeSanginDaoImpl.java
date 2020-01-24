package DAO.Implementation;

import DAO.DAOFactory;
import DAO.interfaces.GroupeSanginDAO;
import Model.GroupeSangin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GroupeSanginDaoImpl implements GroupeSanginDAO {
    private DAOFactory daoFactory;

    public GroupeSanginDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public GroupeSangin findGroupSanginById(int id) {
        String query = "SELECT * from groupesangin where idGS = '"+id+"'";
        try {
            Connection connection = daoFactory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                GroupeSangin groupeSangin = new GroupeSangin(resultSet.getInt("idGS"),resultSet.getString("nomGS"));
                return  groupeSangin;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public GroupeSangin findGroupSanginByName(String nom) {
        String query = "select * from groupesangin where nomGS = '"+nom+"'";
        try {
            Connection connection = daoFactory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                GroupeSangin groupeSangin = new GroupeSangin(resultSet.getInt("idGS"),resultSet.getString("nomGS"));
                return  groupeSangin;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<GroupeSangin> findAll() {
        String query = "select * FROM groupesangin";
        try {
            Connection connection = daoFactory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<GroupeSangin> groupeSangins = new ArrayList<>();
            while(resultSet.next()){
                GroupeSangin groupeSangin = new GroupeSangin(resultSet.getInt("idGS"),resultSet.getString("nomGS"));
                groupeSangins.add(groupeSangin);
            }
            return groupeSangins;
        }catch (SQLException e){
            e.printStackTrace(); e.printStackTrace();
			
        }
        return null;
    }
}
