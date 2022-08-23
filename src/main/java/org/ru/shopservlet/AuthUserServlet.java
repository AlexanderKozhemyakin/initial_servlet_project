package org.ru.shopservlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/shopservletapp/authuser")
public class AuthUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher req = request.getRequestDispatcher("/shopservletapp/registered.jsp");
        req.forward(request, response);
        
        // String username = request.getParameter("login");
        // String password = request.getParameter("password");
        // System.out.println("DEBGGGG:"+username);

        // if (username.isEmpty()||password.isEmpty()){
        //     PrintWriter printWriter = response.getWriter();
        //     String exceptionResponse = "Test 400";
        //     printWriter.println(exceptionResponse);
        // } else {
        //     PrintWriter printWriter = response.getWriter();
        //     String htmlResponse = "<html><h2>Добро пожаловать," + username + "<br/></html>";
        //     printWriter.println(htmlResponse);
        // }
    }
}
