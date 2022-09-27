package org.shopservlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.h2.jdbcx.JdbcConnectionPool;

public class SqlExecutions {
    
    private static ConnectionPoolTest source = new ConnectionPoolTest(JdbcConnectionPool.create("jdbc:h2:tcp://localhost/~/test","sa","as777"));
    
    void createDB() throws IOException, SQLException{
        new DdInitialize(source).executeSql();
    }

    public int getAvailableGoodsCount(String sql) throws SQLException{
    return source.statement(stmt->{
//        String sql = ("select 1 as id from dual");
        ResultSet resultSet = stmt.executeQuery(sql);
        resultSet.next();
        int a = resultSet.getInt(1);
        return a;
    });
    }
    public ArrayList getProducts(String sql) throws SQLException {
        return (ArrayList) source.statement(stmt->{
            List<Products> products = new ArrayList<>();
            ResultSet resultSet = stmt.executeQuery(sql);
            resultSet.next();
            while (resultSet.next()){
                Products p = new Products();
                p.setId(resultSet.getInt("id"));
                p.setName(resultSet.getString("name"));
                p.setDesc(resultSet.getString("desc"));
                products.add( p);
            }
            return products;
        });
    }
}
