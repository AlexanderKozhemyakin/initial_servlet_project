package org.ru.shopservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
    urlPatterns = "/authuser",
    initParams = @WebInitParam(name = "CookieMaxAge", value = "3600", description = "Default value is 1 hour")
    )
public class AuthUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        response.setContentType( "text/html" );
        response.setCharacterEncoding( "UTF-8" );

        final String USERNAME = request.getParameter("login");
        final String PASSWORD = request.getParameter("password");


        if (USERNAME.isEmpty()||PASSWORD.isEmpty()){

            final Cookie errorCodeCookie = new Cookie("code", "400" );
         
            response.addCookie(errorCodeCookie);
            response.sendError(400);

        } else {
            final PrintWriter printWriter = response.getWriter();
            printWriter.println("<html><h2>Добро пожаловать," + USERNAME + "<br/></html>");
        }
    }
}
