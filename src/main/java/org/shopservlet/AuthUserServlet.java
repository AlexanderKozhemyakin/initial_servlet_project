package org.shopservlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.shopservlet.SessionUtils.isClientNotAuthenticated;

@WebServlet(
    urlPatterns = "/authuser",
    initParams = @WebInitParam(name = "CookieMaxAge", value = "3600", description = "Default value is 1 hour")
    )
public class AuthUserServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType( "text/html" );
        response.setCharacterEncoding( "UTF-8" );

        final String USERNAME = request.getParameter("login");
        final String PASSWORD = request.getParameter("password");

        RequestDispatcher requestDispatcher = null;

         if  (LoginValidate.isValid(USERNAME,PASSWORD)){
            if (isClientNotAuthenticated(request.getRequestURI())) {
                final Cookie authCodeCookie = new Cookie("authenticated", "yes");
                response.addCookie(authCodeCookie);
            }
            request.getRequestDispatcher("/main?catalog" ).forward(request, response);

        }else if (USERNAME.isEmpty()||PASSWORD.isEmpty()){

            final Cookie errorCodeCookie = new Cookie("code", "400" );
            response.addCookie(errorCodeCookie);
            errorCodeCookie.setPath("/");
            
            response.sendError(400);
        } else {
            request.getRequestDispatcher("/Login.html" ).forward(request, response);
        }
    }
}
