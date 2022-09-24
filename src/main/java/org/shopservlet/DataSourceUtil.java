package org.shopservlet;

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
        properties = new Properties();
        try {
            properties.load(new FileInputStream("resources/database.properties"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        dataSource = new HikariDataSource();
        dataSource.setDriverClassName(properties.getProperty(H2DRIVERCLASS));
        dataSource.setJdbcUrl(properties.getProperty(H2URL));
        dataSource.setUsername(properties.getProperty(H2USERNAME));
        dataSource.setPassword(properties.getProperty(H2PASSWORD));
    }
    public static DataSource getDataSource(){
        return dataSource;
    }
}