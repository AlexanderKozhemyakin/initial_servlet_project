package org.shopservlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet(urlPatterns = "/simpleregister")
public class SimpleRegister extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        final String USERNAME = request.getParameter("login");
        final String PASSWORD = request.getParameter("password");
        final String NAME = request.getParameter("first_name");
        final String LASTNAME = request.getParameter("last_name");
        final String ADDRESS = request.getParameter("userCity");
        final String EMAIL = request.getParameter("email");
        final String CONTACTNUMBER = request.getParameter("contact_number");
        PrintWriter pw = response.getWriter();

        Connection connection = null;
        try{
            if(connection==null || connection.isClosed()){
                connection = DbUtils.getConnection();
            }
        PreparedStatement ps=connection.prepareStatement(
                "insert into WEBUSERS values(?,?,?,?,?,?,?)");

        ps.setString(1,USERNAME);
        ps.setString(2,PASSWORD);
        ps.setString(3,NAME);
        ps.setString(4,LASTNAME);
        ps.setString(5,ADDRESS);
        ps.setString(6,EMAIL);
        ps.setString(7,CONTACTNUMBER);

        int i=ps.executeUpdate();
        if(i>0)
            pw.print(NAME + ", you are successfully registered!");

    }catch (Exception e2) {System.out.println(e2);}
//todo 1
        pw.close();
    }
}
