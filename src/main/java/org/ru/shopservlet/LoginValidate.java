package org.ru.shopservlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginValidate {
    public static boolean isValid(String login, String password){
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        boolean userFounded = false;

        try{
            connection = DbUtils.getConnection();
    
            preparedStatement = connection.prepareStatement("SELECT 1 FROM WEBUSERS WHERE USERNAME=? AND PASSWORD=?");
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            if (resultSet.getInt(1)==1){
                userFounded = true;
            }else{
                userFounded = false;
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            DbUtils.dbCleanUp(connection, preparedStatement, resultSet);
        }
       return userFounded;
    }
}
