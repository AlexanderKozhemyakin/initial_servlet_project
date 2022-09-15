package org.ru.shopservlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
    urlPatterns = "/authuser",
    initParams = @WebInitParam(name = "CookieMaxAge", value = "3600", description = "Default value is 1 hour")
    )
public class AuthUserServlet extends HttpServlet {

    private static final long serialVersionUID=1L;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        response.setContentType( "text/html" );
        response.setCharacterEncoding( "UTF-8" );

        PrintWriter printWriter = response.getWriter();

        final String USERNAME = request.getParameter("login");
        final String PASSWORD = request.getParameter("password");

        HttpSession session = request.getSession(false);
        if (session!=null){
            session.setAttribute("name", USERNAME);
        }

        RequestDispatcher requestDispatcher = null;

        //printWriter.print(LoginValidate.testCon(USERNAME,PASSWORD));

        if(LoginValidate.isValid(USERNAME,PASSWORD)){
            requestDispatcher = request.getRequestDispatcher("/welcome");
            requestDispatcher.forward(request, response);
        } else if (USERNAME.isEmpty()||PASSWORD.isEmpty()){
            final Cookie errorCodeCookie = new Cookie("code", "400" );
         
            response.addCookie(errorCodeCookie);
            response.sendError(400);
        } else {
            printWriter.print("<p style=\"color:red\">Invalid login or password! Please enter again</p>");
            requestDispatcher = request.getRequestDispatcher("Login.html");
            requestDispatcher.include(request, response);
        }
    }
}
