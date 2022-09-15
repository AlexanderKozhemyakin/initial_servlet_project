package org.ru.shopservlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

public class DataSourceUtil {
    private static final String H2USERNAME="db.username";
    private static final String H2PASSWORD="db.password";
    private static final String H2URL="db.url";
    private static final String H2DRIVERCLASS="driver.class.name";

    private static Properties properties = null;
    private static HikariDataSource dataSource;

    static{
        try{
            properties = new Properties();
            //TO BE FIXED
            // properties.load(new FileInputStream("resources/database.properties"));

            // dataSource = new HikariDataSource();
            // dataSource.setDriverClassName(properties.getProperty(H2DRIVERCLASS));
            // dataSource.setJdbcUrl(properties.getProperty(H2URL));
            // dataSource.setUsername(properties.getProperty(H2USERNAME));
            // dataSource.setPassword(properties.getProperty(H2PASSWORD));
            dataSource = new HikariDataSource();
            dataSource.setDriverClassName("org.h2.Driver");
            dataSource.setJdbcUrl("jdbc:h2:tcp://localhost/~/test");
            dataSource.setUsername("sa");
            dataSource.setPassword("as777");
            dataSource.setMaxLifetime(1000);
            dataSource.setMinimumIdle(50);
            dataSource.setMaximumPoolSize(10000);
            dataSource.setAutoCommit(false);
            dataSource.setLoginTimeout(5);
 
        // } catch (IOException | SQLException e){
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static DataSource getDataSource(){
        return dataSource;
    }
}