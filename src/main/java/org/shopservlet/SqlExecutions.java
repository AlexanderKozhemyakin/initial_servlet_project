package org.shopservlet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.h2.jdbcx.JdbcConnectionPool;

import static org.shopservlet.SessionUtils.generateRandomBase64TokenSessionId;

public class SqlExecutions {
    
    private static ConnectionPoolHandler source = new ConnectionPoolHandler(JdbcConnectionPool.create("jdbc:h2:tcp://localhost/~/test","sa","as777"));

    public static void addProductToCart(String sql, ProductsInChart productsInChart, String url) throws SQLException {
        source.preparedStatement(sql, prepStmt-> {
            prepStmt.setString(1, productsInChart.getSession_id());
            prepStmt.setString(2, productsInChart.getProduct());
            prepStmt.setString(3, productsInChart.getQuantity());
            prepStmt.setString(4, productsInChart.getUsername());
            prepStmt.setString(5, productsInChart.getPrice());
            prepStmt.setString(6, "NEW");
            prepStmt.executeUpdate();
        });
    }
    public static void updateChartWithUsername(String sql, String username, String sessionid) throws SQLException {
        source.preparedStatement(sql, prepStmt-> {
            prepStmt.setString(1, username);
            prepStmt.setString(2, sessionid);
            prepStmt.executeUpdate();
        });
    }
    public static void confirmOrderForClient(String sql, String clientlogin) throws SQLException {
        source.preparedStatement(sql, prepStmt-> {
            prepStmt.setString(1, clientlogin);
            prepStmt.executeUpdate();
        });
    }
    public static String generateAndSaveInDbNewSessionId() throws SQLException{
    return source.statement(stmt->{
        final String generatedSessionId = generateRandomBase64TokenSessionId(55);
        String sql = "INSERT INTO SESSIONS_CARTS (session_id,product,quantity,username,price) values (\'"+generatedSessionId+"\','','','','')";
        stmt.executeUpdate(sql);
        return generatedSessionId;
    });
    }
    public ArrayList getProducts(String sql) throws SQLException {
        return (ArrayList) source.statement(stmt->{
            List<Products> products = new ArrayList<>();
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()){
                Products p = new Products();
                p.setId(resultSet.getInt("id"));
                p.setName(resultSet.getString("name"));
                p.setDesc(resultSet.getString("desc"));
                p.setPrice(resultSet.getString("price"));
                p.setPictureName(resultSet.getString("picture_name"));
                products.add(p);
            }
            return products;
        });
    }

    public ArrayList getProductsInChart(String sql, String sessionId) throws SQLException {
        return (ArrayList) source.preparedStatement(sql, prepStmt-> {
            List<ProductsInChart> productsInChart = new ArrayList<>();
            prepStmt.setString(1, sessionId);
            ResultSet resultSet = prepStmt.executeQuery();
            while (resultSet.next()) {
                ProductsInChart p = new ProductsInChart();
                p.setSession_id(resultSet.getString("session_id"));
                p.setProduct(resultSet.getString("product"));
                p.setQuantity(resultSet.getString("quantity"));
                p.setPrice(resultSet.getString("price"));
                productsInChart.add(p);
            }
            return productsInChart;
        });
    }
}
