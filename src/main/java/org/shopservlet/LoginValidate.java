package org.shopservlet;

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
            if(connection==null || connection.isClosed()){
                connection = DbUtils.getConnection();
            }
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
            preparedStatement.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return userFounded;
    }
}
