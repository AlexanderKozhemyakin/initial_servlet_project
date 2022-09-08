package org.ru.shopservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/authuser")
public class AuthUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        response.setContentType( "text/html" );
        response.setCharacterEncoding( "UTF-8" );

        String username = request.getParameter("login");
        String password = request.getParameter("password");


        if (username.isEmpty()||password.isEmpty()){

            Cookie errorCodeCookie = new Cookie("code", "400" );
          
            errorCodeCookie.setMaxAge(60*60*24);
            
            response.addCookie(errorCodeCookie);
            response.sendError(400);

        } else {
            PrintWriter printWriter = response.getWriter();
            String htmlResponse = "<html><h2>Добро пожаловать," + username + "<br/></html>";
            printWriter.println(htmlResponse);
        }
    }
}
