package org.ru.shopservlet;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtils {

    private static final String DBURL="jdbc:h2:tcp://localhost/~/test";
    private static final String DBUSERNAME="sa";
    private static final String DBPASSWORD="as777";
    private static final String DRIVERNAME="org.h2.Driver";

    static Connection connection = null;
    static{
        try{
            Class.forName(DRIVERNAME);
            connection = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return connection;
    }
    public static void dbCleanUp(Connection connection, Statement statement, ResultSet resultSet){
        if (connection!=null){
            try{
                connection.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    
}
