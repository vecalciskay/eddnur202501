package nur.prog3.basededatos.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySql {

    private final String connectionUrl;
    private final String user;
    private final String password;

    private static ConexionMySql instance;

    private Connection connection;

    private ConexionMySql(String host, String port, String databaseName, String user, String password) {
        this.connectionUrl = "jdbc:mysql://" + host + ":" + port + "/" + databaseName + "?useSSL=false";
        this.user = user;
        this.password = password;
    }

    public static ConexionMySql getInstance() {
        if (instance == null) {
            instance = new ConexionMySql(ConfigLoader.getProperty("db.host"),
                    ConfigLoader.getProperty("db.port"),
                    ConfigLoader.getProperty("db.databaseName"),
                    ConfigLoader.getProperty("db.user"),
                    ConfigLoader.getProperty("db.password"));
        }
        return instance;
    }


    public Connection getConnection() {

        try {
            if(connection != null && !connection.isClosed()){
                return connection;
            }
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(connectionUrl, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                connection = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
