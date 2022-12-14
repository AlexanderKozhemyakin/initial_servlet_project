package org.shopservlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.stream.Collectors;

import com.sun.tools.javac.Main;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DdInitialize {
    final ConnectionPoolHandler source;

    private String parseSqlFromFile(String name) throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(
            new InputStreamReader(
                Main.class.getClassLoader().getResourceAsStream(name), StandardCharsets.UTF_8))){
                    return bufferedReader.lines().collect(Collectors.joining("\n"));
                }
    }
    public void executeSql() throws SQLException, IOException{
        String sql = parseSqlFromFile("/resources/dbcreate.sql");
        source.statement(stmt->{
            stmt.execute(sql);
        });
    }

}
