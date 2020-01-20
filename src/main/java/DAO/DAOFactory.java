package DAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DAOFactory {
    private static final String FICHIER_PROPERTIES ="database.properties";
    private static final String SERVER_NAME ="serverName";
    private static final String PORT ="port";
    private static final String NAME_DB ="nameDB";
    private static final String USERNAME ="username";
    private static final String PASSWORD ="password";
    private String url;
    private String username;
    private String password;

    public DAOFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DAOFactory getInstance(){
        Properties properties =new Properties();
        String url = null;
        String username = null;
        String password = null;

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream(FICHIER_PROPERTIES);

        if(input == null){
            System.out.println("le fichier database.properties est introuvable!");
        }

        try{
            properties.load(input);
            url = "jdbc:mysql://"+properties.getProperty(SERVER_NAME)+":"+properties.getProperty(PORT)+"/"+properties.getProperty(NAME_DB);
            username = properties.getProperty(USERNAME);
            password = properties.getProperty(PASSWORD);
        }catch (IOException e){
            e.printStackTrace();
        }

        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        return new DAOFactory(url,username,password);
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

    //Ajout des methodes d'acces au classes DAO imp
}
