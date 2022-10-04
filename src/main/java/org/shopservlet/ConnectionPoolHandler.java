package org.shopservlet;

import lombok.AllArgsConstructor;
import java.io.UnsupportedEncodingException;
import java.sql.PreparedStatement;

import org.h2.jdbcx.JdbcConnectionPool;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

@AllArgsConstructor
public class ConnectionPoolHandler {

    @FunctionalInterface
    public interface SQLFunction<T,R>{
        R apply(T object) throws SQLException;
    }

    @FunctionalInterface
    public interface SQLConsumer<T>{
        void accept(T object) throws SQLException, UnsupportedEncodingException;
    }

    private final JdbcConnectionPool pool;
//    private final HikariPool pool;

    public void connection(SQLConsumer<? super Connection> consumer) throws SQLException{
        Objects.requireNonNull(consumer);
        try(Connection conn = pool.getConnection()){
            consumer.accept(conn);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public <R> R connection(SQLFunction<? super Connection, ? extends R> function) throws SQLException{
        Objects.requireNonNull(function);
        try(Connection conn=pool.getConnection()){
            return function.apply(conn);
        }
    }

    public <R> R statement (SQLFunction<? super Statement, ? extends R> function) throws SQLException{
        Objects.requireNonNull(function);
        return connection(conn->{
            try(Statement stmt = conn.createStatement()){
                return function.apply(stmt);
            }
        });
    }

    public void statement (SQLConsumer<? super Statement> consumer) throws SQLException{
        Objects.requireNonNull(consumer);
        connection(conn->{
            try(Statement stmt = conn.createStatement()){
                consumer.accept(stmt);
            }
        });
    }

    public <R> R preparedStatement (String sql, SQLFunction<? super PreparedStatement, ? extends R> function) throws SQLException{
        Objects.requireNonNull(function);
        return connection(conn->{
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                return function.apply(stmt);
            }
        });
    }
    public void preparedStatement (String sql, SQLConsumer<? super PreparedStatement> consumer) throws SQLException{
        Objects.requireNonNull(consumer);
        connection(conn->{
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                consumer.accept(stmt);
            }
        });
    }
}