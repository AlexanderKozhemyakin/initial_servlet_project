package org.ru.shopservlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.h2.jdbcx.JdbcConnectionPool;

public class SqlExecutions {
    
    private ConnectionPoolTest source = new ConnectionPoolTest(JdbcConnectionPool.create("jdbc:h2:mem:database;DB_CLOSE_DELAY=1","",""));
    
    void createDB() throws IOException, SQLException{
        new DdInitialize(source).executeSql();
    }

    public int getAvailableGoodsCount() throws SQLException{
    return source.statement(stmt->{
        String sql = ("select 1 as id from dual");
        ResultSet resultSet = stmt.executeQuery(sql);
        return resultSet.getInt(1);
    });
    }
}
