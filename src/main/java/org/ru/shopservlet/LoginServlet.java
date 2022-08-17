package org.ru.shopservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        getServletContext().log("username:" + username);

        PrintWriter printWriter = response.getWriter();
        String htmlResponse = "<html>";
        htmlResponse +="<h2>Hi, " + username + "<br/>";
        htmlResponse +="</html>";
        printWriter.println(htmlResponse);
    }
}
