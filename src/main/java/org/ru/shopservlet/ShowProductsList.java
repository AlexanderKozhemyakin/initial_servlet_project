package org.ru.shopservlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ShowProductsList extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.println("helloworld");
    
    }
    public ArrayList<String> getProductsList(){
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = null;

        ArrayList<String> arrayList = new ArrayList<>();

        try{
            if(connection==null || connection.isClosed()){
               connection = DbUtils.getConnection();
            }
    
            preparedStatement = connection.prepareStatement("SELECT * FROM PRODUCTS");

            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                arrayList.add(resultSet.getString("name"));
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            DbUtils.dbCleanUp(connection, preparedStatement, resultSet);
        }
       return arrayList;
    }
}